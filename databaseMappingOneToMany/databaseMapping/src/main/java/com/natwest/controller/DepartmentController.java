package com.natwest.controller;
import com.natwest.entity.Department;
import com.natwest.entity.Employee;
import com.natwest.service.DepartmentService;
import com.natwest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/department")
    ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.OK);
    }

    @GetMapping("/department")
    ResponseEntity<List<Department>> getDepartment(){
        return new ResponseEntity<>(departmentService.getAllDepartment(),HttpStatus.OK);
    }
}
