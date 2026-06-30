package com.yatra.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yatra.trip.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>{

}
