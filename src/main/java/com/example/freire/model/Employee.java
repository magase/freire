package com.example.freire.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surename;


    private String job;

    @Column(nullable=false, unique=true)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateHire;

    private Float sal;

/*
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "jefe", foreignKey = @ForeignKey(name = "FK_jefe_empleado"))
    @JoinColumn(name = "jefe")
    Employee jefe;

 */

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "departamento", foreignKey = @ForeignKey(name = "FK_id_departamento"))
    @JoinColumn(name = "departament")
    Departament departament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateHire() {
        return dateHire;
    }

    public void setDateHire(Date dateHire) {
        this.dateHire = dateHire;
    }

    public Float getSal() {
        return sal;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", dateHire=" + dateHire +
                ", sal=" + sal +
                ", departament=" + departament +
                '}';
    }
}
