package com.natwest.controller;

import com.natwest.entity.Employee;
import com.natwest.service.DepartmentService;
import com.natwest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/employee")
    ResponseEntity<Employee> addEmployee(@RequestBody Employee user){
        return new ResponseEntity<>(employeeService.addEmployee(user), HttpStatus.OK);
    }

    @GetMapping("/employees")
    ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllUser(),HttpStatus.OK);
    }
}
