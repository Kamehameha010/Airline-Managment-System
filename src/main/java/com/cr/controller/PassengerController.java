package com.cr.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.cr.model.Passenger;
import com.cr.services.repository.jdbc.PassengerRepository;

public class PassengerController {

    PassengerRepository _repository;

    public PassengerController() throws IOException {
        _repository = new PassengerRepository();
    }

    public void create(Passenger model) {
        _repository.create(model);
    }

    public void update(Passenger model) {
        _repository.update(model);
    }

    public Passenger find(Predicate<Passenger> filter) {
        return _repository.find(filter);
    }

    public List<Passenger> getAll() {
        return _repository.getAll();
    }

}
