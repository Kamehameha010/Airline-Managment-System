package com.cr.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.cr.model.Plane;
import com.cr.services.repository.jdbc.PlaneRepository;

public class PlaneController {

    PlaneRepository _repository;

    public PlaneController() throws IOException {

        _repository = new PlaneRepository();
    }

    public void create(Plane model) {
        _repository.create(model);
    }

    public void update(Plane model) {
        _repository.update(model);
    }

    public List<Plane> getAll() {
        return _repository.getAll();
    }

    public Plane fing(Predicate<Plane> filter) {
        return _repository.find(filter);
    }

}
