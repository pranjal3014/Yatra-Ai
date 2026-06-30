package com.yatra.trip.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatra.trip.dto.TripRequest;
import com.yatra.trip.dto.TripResponse;
import com.yatra.trip.service.TripService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trips")
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
	
	@GetMapping("/{id}")
	public ResponseEntity<TripResponse> getById(@PathVariable int id){
		return ResponseEntity.ok(tripService.findByIdTrip(id));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TripResponse>> getAll(){
		return ResponseEntity.ok(tripService.findAllTrip());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TripResponse> updateById(@PathVariable int id, @Valid @RequestBody TripRequest request){
		return ResponseEntity.ok(tripService.updateTrip(id, request));
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		boolean status = tripService.deleteById(id);
		if(status)
			return "Data Deleted Successfully";
		return "Data Not Found";
	}
}
