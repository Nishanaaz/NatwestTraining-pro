package com.natwest.service;

import com.natwest.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartment();
}
