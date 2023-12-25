package com.amadeus.casestudy.dao;

import com.amadeus.casestudy.model.Airport;

import java.util.List;
import java.util.Optional;

public class AirportDao implements Dao<Airport>{
    @Override
    public Optional<Airport> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Airport> getAll() {
        return null;
    }

    @Override
    public void save(Airport airport) {

    }

    @Override
    public void update(Airport airport, String[] params) {

    }

    @Override
    public void delete(Airport airport) {

    }
}
