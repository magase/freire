package com.example.freire.service;

import com.example.freire.model.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    Employee getEmployeeByEmail(String email);

    List<Employee> getByName(String name);

    Employee getEmployeeById(Long id);


    Employee updateEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployeeById(Long id);
}
