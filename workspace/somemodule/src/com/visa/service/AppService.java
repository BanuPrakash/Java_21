package com.visa.service;

import com.visa.repo.EmployeeRepo;

public class AppService {
    EmployeeRepo employeeRepo = new EmployeeRepo();

    public void saveEmployee() {
        employeeRepo.saveEmployee();
    }
}
