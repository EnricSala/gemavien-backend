package com.gemavi.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gemavi.backend.domain.Company;
import com.gemavi.backend.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable String companyId) {
		LOG.info("requested company by id {}", companyId);
		return companyService.getCompany(companyId).orElse(null);
	}

}
