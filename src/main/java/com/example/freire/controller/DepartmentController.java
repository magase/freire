package com.example.freire.controller;

import com.example.freire.model.Departament;
import com.example.freire.service.DepartamentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {
    @Autowired
    private DepartamentService departamentService;

    @GetMapping({ "/departament", "/departament/"})
    public String departament(Model model){
        model.addAttribute("departament", departamentService.getAllDepartaments());
        return "/departament/departament";
    }


    @GetMapping("/departament/new")
    public String departmentNew(Model model){
        Departament departament = new Departament();
        model.addAttribute("departament", departament);
        return "/departament/new_departament";
    }

    @PostMapping("/departament/new")
    public String saveDepartament(@Valid @ModelAttribute("departament") Departament departament, BindingResult result, Model model){
        Departament existing = departamentService.getDepartamentByNameAndLocation(departament.getName(), departament.getLocation());
        if (existing != null) {
            result.rejectValue("nombre", null, "Este nombre ya esta registrado ");
            result.rejectValue("localidad", null, "Esta localidad ya esta registrado ");
            return "redirect:/departament/new?exist";

        }
        if (result.hasErrors()){
            model.addAttribute("departament", departament);
            return "redirect:/departament/new?error";
        }

        departamentService.saveDepartament(departament);
        return "redirect:/departament?success";
    }

    @GetMapping("/departament/edit/{id}")
    public String editDepartamentForm(@PathVariable Long id, Model model){
        Departament dpt = departamentService.getDepartamentById(id);
        model.addAttribute("departament", dpt);
        return "/departament/edit_departament";
    }



    @GetMapping("/departament/delete/{id}")
    public String deleteDepartament(@PathVariable Long id){
        departamentService.deleteDepartamentById(id);
        return "redirect:/departament";

    }
}
