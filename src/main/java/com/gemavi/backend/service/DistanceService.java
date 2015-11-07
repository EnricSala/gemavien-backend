package com.gemavi.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gemavi.backend.domain.Company;
import com.gemavi.backend.domain.Office;
import com.gemavi.backend.service.distance.Coordinates;
import com.gemavi.backend.service.distance.Distance;

@Service
public class DistanceService {

	private static final double EARTH_RADIUS = 6371000;

	public List<Distance> calculateDistances(Coordinates origin, Company company) {
		List<Office> offices = company.getOffices();
		return offices.stream().map(off -> {
			Coordinates destination = new Coordinates(off.getLat(), off.getLng());
			double dist = straightLineDistance(origin, destination);
			return new Distance(dist, off);
		}).sorted().collect(Collectors.toList());
	}

	private double straightLineDistance(Coordinates origin, Coordinates destination) {
		double dLat = toRad(destination.getLat() - origin.getLat());
		double dLng = toRad(destination.getLng() - origin.getLng());

		double lat1 = toRad(origin.getLat());
		double lat2 = toRad(destination.getLat());

		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.sin(dLng / 2) * Math.sin(dLng / 2) * Math.cos(lat1) * Math.cos(lat2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c;
	}

	private double toRad(double degrees) {
		return degrees * Math.PI / 180;
	}

}
