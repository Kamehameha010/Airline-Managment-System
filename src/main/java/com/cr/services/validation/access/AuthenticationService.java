package com.cr.services.validation.access;

import java.io.IOException;
import java.util.function.Predicate;

import com.cr.model.Employee;
import com.cr.model.viewModels.EmployeeViewModel;
import com.cr.services.repository.jdbc.EmployeeRepository;

public class AuthenticationService implements IAuthenticationService {

    private EmployeeRepository _repository;

    public AuthenticationService() throws IOException {
        _repository = new EmployeeRepository();
    }

    @Override
    public Employee isUserValid(EmployeeViewModel model) {
        Predicate<Employee> filter = user -> user.getUsername().equals(model.getUsername())
                && user.getPassword().equals(model.getPassword());
        return _repository.find(filter);
    }

}
