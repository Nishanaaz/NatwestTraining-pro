package com.natwest.service;

import com.natwest.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface EmployeeService {
    Employee addEmployee(Employee user);
    List<Employee> getAllUser();

}
