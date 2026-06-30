package com.yatra.trip.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.yatra.trip.dto.TripRequest;
import com.yatra.trip.dto.TripResponse;
import com.yatra.trip.entity.Trip;
import com.yatra.trip.exception.TripNotFoundException;
import com.yatra.trip.repository.TripRepository;
import com.yatra.trip.service.TripService;

@Service
public class TripServiceImpl implements TripService{
	
	private TripRepository tripRepository;

	public TripServiceImpl(TripRepository tripRepository) {
		super();
		this.tripRepository = tripRepository;
	}
	
	//add trip
	@Override
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
	
	
	//find by id
	@Override
	public TripResponse findByIdTrip(int id) {
		Trip trip = tripRepository.findById(id).orElseThrow(()->new TripNotFoundException("Trip Not Found!!!"));
		return convertToDto(trip);
	}

	//find all
	@Override
	public List<TripResponse> findAllTrip() {
		List<Trip> trips = tripRepository.findAll();
		
		return trips.stream()
	            .map(this::convertToDto)
	            .toList();
	}

	//update
	@Override
	public TripResponse updateTrip(int id, TripRequest request) {
		Trip trip = tripRepository.findById(id).orElseThrow(()->new TripNotFoundException("Trip Not Found!!!"));
		 	trip.setSource(request.getSource());
		    trip.setDestination(request.getDestination());
		    trip.setStartDate(request.getStartDate());
		    trip.setEndDate(request.getEndDate());
		    trip.setBudget(request.getBudget());
		    trip.setGroupSize(request.getGroupSize());
		    trip.setTravelStyle(request.getTravelStyle());
		    
		Trip updatedTrip = tripRepository.save(trip);
		return convertToDto(updatedTrip);
	}

	@Override
	public boolean deleteById(int id) {
		boolean status = false;
		Trip trip = tripRepository.findById(id).orElseThrow(()->new TripNotFoundException("Trip Not Found!!!"));
		if(trip != null) {
			tripRepository.deleteById(id);
			return true;
		}
		return false;
	}

	//convert trip object to dto
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
