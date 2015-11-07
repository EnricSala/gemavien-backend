package com.gemavi.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gemavi.backend.domain.Office;
import com.gemavi.backend.repository.OfficeRepository;

@Service
public class CheckinService {

	private static final Logger LOG = LoggerFactory.getLogger(CheckinService.class);

	@Autowired
	private OfficeRepository officeRepository;

	@Autowired
	private EventMonitorService eventMonitor;

	@Transactional
	public Office addVisitor(String officeId) {
		Office office = officeRepository.findOne(officeId);
		if (office != null) {
			office.inc();
			eventMonitor.onEnter();
			return officeRepository.save(office);
		}
		return office;
	}

	@Transactional
	public Office removeVisitor(String officeId) {
		Office office = officeRepository.findOne(officeId);
		if (office != null) {
			int prevCount = office.getCount();
			office.dec();
			if (office.getCount() != prevCount) {
				eventMonitor.onLeave();
				office = officeRepository.save(office);
			}
		}
		return office;
	}

}
