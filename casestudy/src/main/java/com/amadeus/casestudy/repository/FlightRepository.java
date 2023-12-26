package com.amadeus.casestudy.repository;

import com.amadeus.casestudy.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Integer>, SearchRepository {

}
