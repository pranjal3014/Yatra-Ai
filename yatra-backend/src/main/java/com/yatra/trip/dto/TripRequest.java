package com.yatra.trip.dto;

import java.time.LocalDate;

import com.yatra.common.enums.TravelStyle;

import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

@Data
public class TripRequest {
	String source;
	String destination;
	LocalDate startDate;
	LocalDate endDate;
	Double budget;
	Integer groupSize;
	TravelStyle travelStyle;
	
	@AssertTrue(message = "End date must be after start date")
    public boolean isValidDateRange() {

        if (startDate == null || endDate == null) {
            return true;
        }

        return endDate.isAfter(startDate);
    }
}
