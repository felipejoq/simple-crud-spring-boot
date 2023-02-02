package com.uncodigo.practicebackend.repository;

import com.uncodigo.practicebackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
