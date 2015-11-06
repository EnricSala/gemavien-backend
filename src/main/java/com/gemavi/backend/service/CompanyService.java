package com.gemavi.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemavi.backend.domain.Company;
import com.gemavi.backend.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companies;

	public Optional<Company> getCompany(String companyId) {
		Company company = companies.findOne(companyId);
		return Optional.ofNullable(company);
	}

}
