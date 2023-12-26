package com.amadeus.casestudy.controller;

import com.amadeus.casestudy.model.Flight;
import com.amadeus.casestudy.repository.FlightRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
public class SearchController {
    private final FlightRepository flightRepository;

    public SearchController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flights/search")
    public Iterable<Flight> searchFlights(@RequestParam(required = false) String departureAirport,
                                          @RequestParam(required = false) String arrivalAirport,
                                          @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date departureTime,
                                          @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date returnTime) {
        return flightRepository.searchFlights(departureAirport, arrivalAirport, departureTime, returnTime);
    }
}
