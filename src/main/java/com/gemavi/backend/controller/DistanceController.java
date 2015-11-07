package com.gemavi.backend.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gemavi.backend.domain.Company;
import com.gemavi.backend.service.CompanyService;
import com.gemavi.backend.service.DistanceService;
import com.gemavi.backend.service.distance.Coordinates;
import com.gemavi.backend.service.distance.Distance;

@RestController
@RequestMapping("/api/distance")
public class DistanceController {

	private static final Logger LOG = LoggerFactory.getLogger(DistanceController.class);

	@Autowired
	private CompanyService companyService;

	@Autowired
	private DistanceService distanceService;

	@RequestMapping(value = "/{companyId}")
	private List<Distance> getDistances(@PathVariable String companyId,
			@RequestParam double lat,
			@RequestParam double lng) {
		Coordinates origin = new Coordinates(lat, lng);
		LOG.info("Request distances to companyId {} from {}", companyId, origin);

		Optional<Company> company = companyService.getCompany(companyId);
		if (company.isPresent()) {
			return distanceService.calculateDistances(origin, company.get());
		} else {
			return Collections.emptyList();
		}
	}

}
