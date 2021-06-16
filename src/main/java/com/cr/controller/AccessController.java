package com.cr.controller;

import java.io.IOException;
import java.util.Optional;

import com.cr.model.Employee;
import com.cr.model.viewModels.EmployeeViewModel;
import com.cr.services.validation.access.AuthenticationService;
import com.cr.services.validation.access.IAuthenticationService;

public class AccessController {
    
    private IAuthenticationService _service;

    public AccessController() throws IOException{
        _service = new AuthenticationService();
    }

    public Optional<Employee> Autheticate(EmployeeViewModel model){
        return Optional.of(_service.isUserValid(model));
    }

}
