package com.gemavi.backend.domain;

import java.util.List;

public class Company {

	private String id;

	private List<String> officeIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getOfficeIds() {
		return officeIds;
	}

	public void setOfficeIds(List<String> officeIds) {
		this.officeIds = officeIds;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", officeIds=" + officeIds + "]";
	}

}
