package com.amadeus.casestudy.repository;

import com.amadeus.casestudy.model.Flight;
import com.amadeus.casestudy.model.RoundTripDto;

import java.util.Date;

public interface SearchRepository {

    public Iterable<Flight> searchFlights(String departureAirport, String arrivalAirport, Date departureTime);

    public RoundTripDto searchFlights(String departureAirport, String arrivalAirport, Date departureTime, Date returnTime);
}
