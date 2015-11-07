package com.gemavi.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class EventMonitorService {

	private static final Logger LOG = LoggerFactory.getLogger(EventMonitorService.class);

	private static final String ENTER = "enter";
	private static final String LEAVE = "leave";

	private List<DeferredResult<String>> pendingResults;

	public EventMonitorService() {
		pendingResults = new ArrayList<>();
	}

	public void onEnter() {
		String response = ENTER;
		LOG.info("Broadcasting {} event", response);
		pendingResults.forEach(r -> r.setResult(response));
	}

	public void onLeave() {
		String response = LEAVE;
		LOG.info("Broadcasting {} event", response);
		pendingResults.forEach(r -> r.setResult(response));
	}

	public void addListener(DeferredResult<String> pending) {
		pendingResults.add(pending);
	}

}
