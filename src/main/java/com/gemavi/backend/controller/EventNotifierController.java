package com.gemavi.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.gemavi.backend.service.EventMonitorService;

@Controller
@RequestMapping("/api/polling")
public class EventNotifierController {

	private static final Logger LOG = LoggerFactory.getLogger(EventMonitorService.class);

	private static final Long POLL_TIMEOUT = 60 * 1000L;
	private static final String DEFAULT_RESPONSE = "";

	@Autowired
	private EventMonitorService eventMonitor;

	@RequestMapping(value = "")
	public @ResponseBody DeferredResult<String> poll() {
		LOG.info("Adding event lister");
		DeferredResult<String> result = new DeferredResult<>(POLL_TIMEOUT, DEFAULT_RESPONSE);
		eventMonitor.addListener(result);
		return result;
	}

}
