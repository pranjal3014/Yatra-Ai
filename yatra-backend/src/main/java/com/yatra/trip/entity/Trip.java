package com.yatra.trip.entity;

import java.time.LocalDate;

import com.yatra.common.enums.TravelStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Trips")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trip_id;
	
	@NotNull
	@Column(name="source")
	private String source;
	
	@NotNull
	@Column(name="destination")
	private String destination;
	
	@NotNull
	@Column(name="start_date")
	private LocalDate startDate;
	
	@NotNull
	@Column(name="end_date")
	private LocalDate endDate;
	
	@NotNull
	@Column(name="budget")
	private Double budget;
	
	@NotNull
	@Column(name="group_size")
	private int groupSize;
	
	@Enumerated(EnumType.STRING)
	private TravelStyle travelStyle;
}
