package com.uncodigo.practicebackend.service;

import com.uncodigo.practicebackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee, Long id);
    Employee deleteEmployeeById(Long id);
}
