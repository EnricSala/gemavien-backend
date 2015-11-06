package com.gemavi.backend.domain;

public class Office {

	private String id;

	private String name;

	private long lat, lng;

	private int count;

	public int inc() {
		count += 1;
		return count;
	}

	public int dec() {
		count -= 1;
		return count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public long getLng() {
		return lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", name=" + name + ", lat=" + lat + ", lng=" + lng + ", count=" + count + "]";
	}

}
