package com.yatra.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yatra.trip.exception.TripNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TripNotFoundException.class)
	public ResponseEntity<Map<String, String>> customTripException(TripNotFoundException ex){
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", "Trip Not Found\nTry Again!!!");
		return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
	}
}
