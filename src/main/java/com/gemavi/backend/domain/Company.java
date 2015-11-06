package com.gemavi.backend.domain;

import java.util.List;

public class Company {

	private String id;

	private List<Office> offices;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Office> getOffices() {
		return offices;
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}

}
