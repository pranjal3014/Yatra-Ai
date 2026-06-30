package com.yatra.trip.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TripSummaryResponse {
	
	private Long id;
	private String source;
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
}
