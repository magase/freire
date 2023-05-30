package com.example.freire.repositories;

import com.example.freire.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Departament, Long> {

    @Override
    List<Departament> findAll();

    Departament findDepartamentById(Long id);
    List<Departament> findByName(String name);
    List<Departament> findByLocation(String location);


    Departament findDepartamentByNameAndLocation(String name, String location);
}
