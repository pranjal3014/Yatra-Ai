package com.yatra.trip.service;

import com.yatra.trip.dto.TripRequest;
import com.yatra.trip.dto.TripResponse;

public interface TripService {
	
	//add
	TripResponse saveTrip(TripRequest request);
}
