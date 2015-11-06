package com.gemavi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gemavi.backend.domain.Office;
import com.gemavi.backend.repository.OfficeRepository;

@Service
public class CheckinService {

	@Autowired
	private OfficeRepository officeService;

	@Transactional
	public Office addVisitor(String officeId) {
		Office office = officeService.findOne(officeId);
		office.inc();
		return officeService.save(office);
	}

	@Transactional
	public Office removeVisitor(String officeId) {
		Office office = officeService.findOne(officeId);
		office.dec();
		return officeService.save(office);
	}

}
