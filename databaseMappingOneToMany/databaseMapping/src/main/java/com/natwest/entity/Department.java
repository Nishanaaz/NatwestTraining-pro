package com.natwest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    private String name;
    private String manager;

    @JsonBackReference
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    List<Employee > employee = new ArrayList<>();
    public Department(){

    }

    public Department(int deptId, String name, String manager) {
        this.deptId = deptId;
        this.name = name;
        this.manager = manager;
    }

    public int getDeptId() {
        return deptId;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

//    {
//    "deptId":1,
//        "name" :"Namreen",
//        "manager" : "Monika Gupta"
//}
}