package com.amadeus.casestudy.controller;

import com.amadeus.casestudy.model.Flight;
import com.amadeus.casestudy.model.RoundTripDto;
import com.amadeus.casestudy.repository.FlightRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@SecurityRequirement(name = "basicAuth")
public class SearchController {
    private final FlightRepository flightRepository;

    public SearchController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flights/one-way")
    public Iterable<Flight> searchFlights(@RequestParam(required = false) String departureAirport,
                                                    @RequestParam(required = false) String arrivalAirport,
                                                    @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date departureTime) {
        return flightRepository.searchFlights(departureAirport, arrivalAirport, departureTime);
    }

    @GetMapping("/flights/two-way")
    public RoundTripDto searchFlights(@RequestParam(required = false) String departureAirport,
                                      @RequestParam(required = false) String arrivalAirport,
                                      @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date departureTime,
                                      @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date returnTime) {
        return flightRepository.searchFlights(departureAirport, arrivalAirport, departureTime, returnTime);
    }
}
