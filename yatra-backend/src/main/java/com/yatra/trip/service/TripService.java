package com.yatra.trip.service;

import java.util.List;

import com.yatra.trip.dto.TripRequest;
import com.yatra.trip.dto.TripResponse;

public interface TripService {
	
	//add
	TripResponse saveTrip(TripRequest request);
	
	//get
	TripResponse findByIdTrip(int id);
	
	//get All
	List<TripResponse> findAllTrip();
	
	//update
	TripResponse updateTrip(int id,TripRequest request);
	
	//delete
	boolean deleteById(int id);
}
