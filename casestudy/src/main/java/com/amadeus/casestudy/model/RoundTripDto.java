package com.amadeus.casestudy.model;

public class RoundTripDto {
    private Iterable<Flight> outboundFlights;
    private Iterable<Flight> inboundFlights;

    public RoundTripDto(Iterable<Flight> outboundFlights, Iterable<Flight> inboundFlights) {
        this.outboundFlights = outboundFlights;
        this.inboundFlights = inboundFlights;
    }

    public Iterable<Flight> getOutboundFlights() {
        return outboundFlights;
    }

    public void setOutboundFlights(Iterable<Flight> outboundFlights) {
        this.outboundFlights = outboundFlights;
    }

    public Iterable<Flight> getInboundFlights() {
        return inboundFlights;
    }

    public void setInboundFlights(Iterable<Flight> inboundFlights) {
        this.inboundFlights = inboundFlights;
    }
}
