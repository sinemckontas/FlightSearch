package com.amadeus.casestudy.controller;

import com.amadeus.casestudy.model.Airport;
import com.amadeus.casestudy.repository.AirportRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@SecurityRequirement(name = "basicAuth")
public class AirportController {
    private final AirportRepository airportRepository;

    public AirportController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping("/airports")
    public Iterable<Airport> getAirports() {
        return airportRepository.findAll();
    }

    @GetMapping("/airport/{airportId}")
    public Airport getAirport(@PathVariable Integer airportId) {
        Optional<Airport> airport = airportRepository.findById(airportId);
        if (airport.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport with ID: " + airportId.toString() + " not found.");
        }
        return airport.get();
    }

    @PostMapping("/airports")
    public Airport addAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @PutMapping("/airport/{airportId}")
    public Airport updateAirport(@PathVariable Integer airportId, @RequestBody Airport airport) {
        Optional<Airport> airportToUpdate = airportRepository.findById(airportId);
        if (airportToUpdate.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport with ID: " + airportId.toString() + " not found.");
        }
        airport.setId(airportToUpdate.get().getId());
        return airportRepository.save(airport);
    }

    @DeleteMapping("/airport/{airportId}")
    public void deleteAirport(@PathVariable Integer airportId) {
        Optional<Airport> airport = airportRepository.findById(airportId);
        if (airport.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport with ID: " + airportId.toString() + " not found.");
        }
        airportRepository.delete(airport.get());
    }

}
