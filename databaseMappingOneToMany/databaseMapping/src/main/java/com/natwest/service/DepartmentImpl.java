package com.natwest.service;

import com.natwest.entity.Department;
import com.natwest.entity.Employee;
import com.natwest.repository.DepartmentRepository;
import com.natwest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Department addDepartment(Department department) {
        Department department1 = departmentRepository.save(department);
        return department1;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
