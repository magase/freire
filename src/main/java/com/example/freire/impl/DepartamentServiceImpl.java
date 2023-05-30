package com.example.freire.impl;

import com.example.freire.model.Departament;
import com.example.freire.repositories.DepartmentRepo;
import com.example.freire.service.DepartamentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentServiceImpl implements DepartamentService {
    private DepartmentRepo departmentRepo;


    public DepartamentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public List<Departament> getAllDepartaments() {
        return departmentRepo.findAll();
    }

    @Override
    public List<Departament> getDepartamentByName(String name) {
        return departmentRepo.findByName(name);
    }

    @Override
    public Departament saveDepartament(Departament departament) {
        return departmentRepo.save(departament);
    }

    @Override
    public Departament getDepartamentById(Long id) {
        return departmentRepo.findDepartamentById(id);
    }

    @Override
    public Departament getDepartamentByNameAndLocation(String name, String location) {
        return departmentRepo.findDepartamentByNameAndLocation(name, location);
    }

    @Override
    public void deleteDepartamentById(Long id) {
        departmentRepo.deleteById(id);
    }
}
