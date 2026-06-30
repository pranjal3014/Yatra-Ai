package com.yatra.trip.service.Impl;

import org.springframework.stereotype.Service;

import com.yatra.trip.dto.TripRequest;
import com.yatra.trip.dto.TripResponse;
import com.yatra.trip.entity.Trip;
import com.yatra.trip.repository.TripRepository;
import com.yatra.trip.service.TripService;

@Service
public class TripServiceImpl implements TripService{
	
	private TripRepository tripRepository;

	public TripServiceImpl(TripRepository tripRepository) {
		super();
		this.tripRepository = tripRepository;
	}
	
	public TripResponse saveTrip(TripRequest request) {
	    Trip trip = new Trip();

	    trip.setSource(request.getSource());
	    trip.setDestination(request.getDestination());
	    trip.setStartDate(request.getStartDate());
	    trip.setEndDate(request.getEndDate());
	    trip.setBudget(request.getBudget());
	    trip.setGroupSize(request.getGroupSize());
	    trip.setTravelStyle(request.getTravelStyle());
	    
	    Trip saveTrip = tripRepository.save(trip);
	    return convertToDto(saveTrip);
	}
	
	private TripResponse convertToDto(Trip trip) {
		
		return TripResponse.builder()
				.id(trip.getTrip_id())
	            .source(trip.getSource())
	            .destination(trip.getDestination())
	            .startDate(trip.getStartDate())
	            .endDate(trip.getEndDate())
	            .budget(trip.getBudget())
	            .groupSize(trip.getGroupSize())
	            .travelStyle(trip.getTravelStyle())
	            .build();
	}
}
