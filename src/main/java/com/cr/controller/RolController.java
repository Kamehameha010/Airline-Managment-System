package com.cr.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.cr.model.Rol;
import com.cr.services.repository.jdbc.RolRepository;

public class RolController {

    RolRepository _repository;

    public RolController() throws IOException {

        _repository = new RolRepository();
    }

    public void create(Rol model) {
        _repository.create(model);
    }

    public void update(Rol model) {
        _repository.update(model);
    }

    public List<Rol> getAll() {
        return _repository.getAll();
    }

    public Rol fing(Predicate<Rol> filter) {
        return _repository.find(filter);
    }
}
