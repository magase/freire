package com.example.freire.controller;

import com.example.freire.model.Departament;
import com.example.freire.model.Employee;
import com.example.freire.repositories.DepartmentRepo;
import com.example.freire.service.EmployeeService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepo departmentRepo;


    private List<Departament> departamentList = new ArrayList<>();

    public EmployeeController(EmployeeService employeeService, DepartmentRepo departmentRepo, List<Departament> departamentList) {
        this.employeeService = employeeService;
        this.departmentRepo = departmentRepo;
        this.departamentList = departamentList;
    }

    @GetMapping({ "/employee", "/employee/"})
    public String employeeList(Model model){
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "/employee/employee";
    }

    @GetMapping("/employee/new")
    public String employeeNew(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departamentList", departamentList);
        return "/employee/new_employee";
    }

    @PostMapping("/employee/new")
    public String saveEmpleado(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model){
        Employee existing = employeeService.getEmployeeByEmail(employee.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "Cuenta ya registrada");
        }
        if (result.hasErrors()){
            model.addAttribute("employee", employee);
            //return "crear_employee";
            return "redirect:/employee/new?error";
        }

        employeeService.saveEmployee(employee);
        return "redirect:/employee?success";
    }


    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){
        Employee empl = employeeService.getEmployeeById(id);
        model.addAttribute("employee", empl);
        model.addAttribute("departamentoList", departamentList);

        return "/employee/edit_employee";
    }

    @PostMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model){
        Employee existEmployee = employeeService.getEmployeeById(id);
        existEmployee.setId(id);
        existEmployee.setSurename(employee.getSurename());
        existEmployee.setName(employee.getName());
        existEmployee.setDepartament(employee.getDepartament());
        existEmployee.setJob(employee.getJob());
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setDateHire(employee.getDateHire());
        existEmployee.setSal(employee.getSal());

        employeeService.updateEmployee(existEmployee);
        return "redirect:/employee?update";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";

    }


}
