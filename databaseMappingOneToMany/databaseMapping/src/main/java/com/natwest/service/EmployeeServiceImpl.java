package com.natwest.service;

import com.natwest.entity.Department;
import com.natwest.entity.Employee;
import com.natwest.repository.DepartmentRepository;
import com.natwest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        int deptid1 = employee.getDepartment().getDeptId();
        Department department = departmentRepository.findById(deptid1).get();
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllUser() {
        return employeeRepository.findAll();
    }
}
