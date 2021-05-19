package com.cr.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.cr.model.Employee;
import com.cr.services.repository.jdbc.EmployeeRepository;

public class EmployeeController {

    EmployeeRepository _repository;

    public EmployeeController() throws IOException {
        _repository = new EmployeeRepository();
    }

    public void create(Employee model) {
        _repository.create(model);
    }

    public void update(Employee model) {
        _repository.update(model);
    }

    public Employee find(Predicate<Employee> filter){
        return  _repository.find(filter);
    }

    public List<Employee> getAll(){
        return _repository.getAll();
    }
}
