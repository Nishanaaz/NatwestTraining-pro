package com.natwest.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(nullable = false)
    private String name;

    private String designation;
    //ManyToOne should be Eager
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "deptId")
     Department department;

    public Employee(){


    }

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public Employee(int id, String name, String designation, Department department) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
//{
//     "id" : 3,
//        "name" : "Nisha",
//        "designation" : "b2",
//        "dptId" : 1
//}