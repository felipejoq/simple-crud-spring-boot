package com.uncodigo.practicebackend.service.impl;

import com.uncodigo.practicebackend.exception.ResourceNotFoundException;
import com.uncodigo.practicebackend.model.Employee;
import com.uncodigo.practicebackend.repository.EmployeeRepository;
import com.uncodigo.practicebackend.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        /*
         * Se puede resumir con una expresión lambda:
         *
         * Optional<Employee> employee = this.employeeRepository.findById(id);
         * if (employee.isPresent()) {
         *      return employee.get();
         * } else {
         *      throw new ResourceNotFoundException("Employee", "ID", id);
         * }
         */

        return this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        // Check if employee exist from ID
        Employee existingEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        // Set properties to update.
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPosition(employee.getPosition());

        // Save existing employee
        this.employeeRepository.save(existingEmployee);

        // Return entity Employee
        return existingEmployee;
    }

    @Override
    public Employee deleteEmployeeById(Long id) {
        // Check if employee exist from ID
        Employee existingEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        // Delete this existing employee.
        this.employeeRepository.deleteById(existingEmployee.getId());
        return existingEmployee;
    }
}
