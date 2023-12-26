package com.amadeus.casestudy.controller;

import com.amadeus.casestudy.model.Flight;
import com.amadeus.casestudy.repository.FlightRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flights")
    public Iterable<Flight> getFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/flight/{flightId}")
    public Flight getFlight(@PathVariable Integer flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if (flight.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight with ID: " + flightId.toString() + " not found.");
        }
        return flight.get();
    }

    @PostMapping("/flights")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @PutMapping("/flight/{flightId}")
    public Flight updateFlight(@PathVariable Integer flightId, @RequestBody Flight flight) {
        Optional<Flight> flightToUpdate = flightRepository.findById(flightId);
        if (flightToUpdate.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight with ID: " + flightId.toString() + " not found.");
        }
        flight.setId(flightToUpdate.get().getId());
        return flightRepository.save(flight);
    }

    @DeleteMapping("/flight/{flightId}")
    public void deleteFlight(@PathVariable Integer flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if (flight.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight with ID: " + flightId.toString() + " not found.");
        }
        flightRepository.delete(flight.get());
    }

}
