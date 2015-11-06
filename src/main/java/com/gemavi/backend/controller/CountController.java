package com.gemavi.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemavi.backend.domain.Office;
import com.gemavi.backend.service.CheckinService;

@RestController
@RequestMapping("/api/counter")
public class CountController {

	private static final Logger LOG = LoggerFactory.getLogger(CountController.class);

	@Autowired
	private CheckinService checkins;

	@RequestMapping(value = "/{officeId}/enter")
	public Office enter(@PathVariable String officeId) {
		LOG.info("a visitor entered office={}", officeId);
		return checkins.addVisitor(officeId);
	}

	@RequestMapping(value = "/{officeId}/leave")
	public Office leave(@PathVariable String officeId) {
		LOG.info("a visitor left office={}", officeId);
		return checkins.removeVisitor(officeId);
	}

}
