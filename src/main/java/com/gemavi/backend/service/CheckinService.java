package com.gemavi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gemavi.backend.domain.Office;
import com.gemavi.backend.repository.OfficeRepository;

@Service
public class CheckinService {

	@Autowired
	private OfficeRepository officeRepository;

	@Transactional
	public Office addVisitor(String officeId) {
		Office office = officeRepository.findOne(officeId);
		if (office != null) {
			office.inc();
			return officeRepository.save(office);
		} else {
			return null;
		}
	}

	@Transactional
	public Office removeVisitor(String officeId) {
		Office office = officeRepository.findOne(officeId);
		if (office != null) {
			office.dec();
			return officeRepository.save(office);
		} else {
			return null;
		}
	}

}
