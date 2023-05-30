package com.example.freire.repositories;

import com.example.freire.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    Employee findEmployeeById(Long id);

    Employee findEmployeeByEmail(String email);

    List<Employee> findEmployeeByName(String name);
}
