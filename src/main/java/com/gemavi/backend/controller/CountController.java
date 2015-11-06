package com.gemavi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemavi.backend.domain.Office;
import com.gemavi.backend.service.CheckinService;

@RestController("/api")
public class CountController {

	@Autowired
	private CheckinService checkins;

	@RequestMapping(value = "/counter/{officeId}/enter")
	public Office enter(@PathVariable String officeId) {
		return checkins.addVisitor(officeId);
	}

	@RequestMapping(value = "/counter/{officeId}/leave")
	public Office leave(@PathVariable String officeId) {
		return checkins.removeVisitor(officeId);
	}

}
