package com.amadeus.casestudy.model;
import java.util.*;
public class Flight {

    private int id;
    private String departure;
    private String arrival;
    private Date departure_time;
    private Date arrival_time;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
