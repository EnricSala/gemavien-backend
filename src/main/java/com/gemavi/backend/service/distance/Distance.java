package com.gemavi.backend.service.distance;

import com.gemavi.backend.domain.Office;

public class Distance implements Comparable<Distance> {

	private double straightLine;

	private Office destination;

	public Distance() {
	}

	public Distance(double straightLine, Office destination) {
		this.straightLine = straightLine;
		this.destination = destination;
	}

	public double getStraightLine() {
		return straightLine;
	}

	public void setStraightLine(double straightLine) {
		this.straightLine = straightLine;
	}

	public Office getDestination() {
		return destination;
	}

	public void setDestination(Office destination) {
		this.destination = destination;
	}

	@Override
	public int compareTo(Distance d) {
		return (int) Math.round(this.straightLine - d.getStraightLine());
	}

}
