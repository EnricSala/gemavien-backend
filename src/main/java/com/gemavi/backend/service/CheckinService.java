package com.gemavi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gemavi.backend.domain.Office;
import com.gemavi.backend.repository.OfficeRepository;

@Service
public class CheckinService {

	@Autowired
	private OfficeRepository offices;

	@Transactional
	public Office addVisitor(String officeId) {
		Office office = offices.findOne(officeId);
		office.inc();
		return offices.save(office);
	}

	@Transactional
	public Office removeVisitor(String officeId) {
		Office office = offices.findOne(officeId);
		office.dec();
		return offices.save(office);
	}

}
