package com.cr.services.validation.access;

import com.cr.model.Employee;
import com.cr.model.viewModels.EmployeeViewModel;


public interface IAuthenticationService {

    Employee isUserValid(EmployeeViewModel model);
}
