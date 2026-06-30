package com.yatra.trip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatra.trip.dto.TripRequest;
import com.yatra.trip.dto.TripResponse;
import com.yatra.trip.service.TripService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trip")
public class TripController {

	private TripService tripService;

	public TripController(TripService tripService) {
		super();
		this.tripService = tripService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<TripResponse> addTrip(@Valid @RequestBody TripRequest trip){
		return ResponseEntity.status(HttpStatus.CREATED).body(tripService.saveTrip(trip));
	}
}
