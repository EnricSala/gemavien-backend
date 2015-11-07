package com.gemavi.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Office implements Comparable<Office> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String name;

	private double lat, lng;

	private int count;

	public int inc() {
		count += 1;
		return count;
	}

	public int dec() {
		count -= 1;
		if (count < 0)
			count = 0;
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

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
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

	@Override
	public int compareTo(Office off) {
		return this.count - off.count;
	}

}
