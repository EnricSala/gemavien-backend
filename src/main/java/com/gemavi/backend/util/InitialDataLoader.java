package com.gemavi.backend.util;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemavi.backend.domain.Company;
import com.gemavi.backend.domain.Office;
import com.gemavi.backend.repository.CompanyRepository;
import com.gemavi.backend.repository.OfficeRepository;

@Component
@EnableConfigurationProperties(LoaderSettings.class)
public class InitialDataLoader implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(InitialDataLoader.class);

	private static final String INIT_FILE = "default-init-data.json";

	@Autowired
	private LoaderSettings loaderSettings;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private OfficeRepository officeRepository;

	@Override
	public void run(String... args) throws Exception {
		File initFile = loaderSettings.getInitFile();
		if (initFile == null || !initFile.isFile()) {
			LOG.warn("Loading default init file, coult not find at: {}", initFile);
			initFile = new File(this.getClass().getClassLoader().getResource(INIT_FILE).getFile());
		}

		LOG.info("Loading from: {}", initFile);

		ObjectMapper mapper = new ObjectMapper();
		Loader loader = mapper.readValue(initFile, Loader.class);

		List<Company> companies = loader.getCompanies();

		companies.forEach(company -> {
			List<Office> offices = company.getOffices();
			LOG.info("Saving {} offices for Company {}", offices.size(), company.getName());

			if (offices != null && !offices.isEmpty()) {
				// Save offices
				Iterable<Office> ite = officeRepository.save(offices);
				offices = StreamSupport.stream(ite.spliterator(), false).collect(Collectors.toList());

				// Save company, adding the offices
				company.setOffices(offices);
				company = companyRepository.save(company);
				LOG.info("Saved company [{}] with {} offices: {}", company.getName(),
						company.getOffices().size(), company);
			}
		});
	}

	public static class Loader {

		private List<Company> companies;

		public List<Company> getCompanies() {
			return companies;
		}

		public void setCompanies(List<Company> companies) {
			this.companies = companies;
		}

	}

}
