package com.example.freire.service;

import com.example.freire.model.Departament;

import java.util.List;

public interface DepartamentService {


    List<Departament> getAllDepartaments();

    List<Departament> getDepartamentByName(String name);

    Departament saveDepartament(Departament departament);

    Departament getDepartamentById(Long id);

    Departament getDepartamentByNameAndLocation(String name, String location);

    void deleteDepartamentById(Long id);
}
