package com.yatra.trip.dto;

import java.time.LocalDate;

import com.yatra.common.enums.TravelStyle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TripResponse {
	int id;
	String source;
	String destination;
	LocalDate startDate;
	LocalDate endDate;
	Double budget;
	Integer groupSize;
	TravelStyle travelStyle;
}
