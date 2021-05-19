package com.cr.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.cr.model.Flight;
import com.cr.services.repository.jdbc.FlightRepository;

public class FlightController {
    

    FlightRepository _repository;

    public FlightController() throws IOException {
        _repository = new FlightRepository();
    }

    public void create(Flight model) {
        _repository.create(model);
    }

    public void update(Flight model) {
        _repository.update(model);
    }

    public Flight find(Predicate<Flight> filter){
        return  _repository.find(filter);
    }

    public List<Flight> getAll(){
        return _repository.getAll();
    }
}
