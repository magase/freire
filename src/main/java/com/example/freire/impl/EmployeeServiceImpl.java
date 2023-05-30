package com.example.freire.impl;

import com.example.freire.model.Employee;
import com.example.freire.repositories.EmployeeRepo;
import com.example.freire.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepository) {
        this.employeeRepo = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);

    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepo.findEmployeeByEmail(email);
    }



    @Override
    public List<Employee> getByName(String name) {
        return employeeRepo.findEmployeeByName(name);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }
}
