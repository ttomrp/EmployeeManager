package com.tom.employeemanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.tom.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // @Query("SELECT e FROM employeemanager e WHERE e.id = ?1")
    Optional<Employee> findEmployeeById(Long id);
}
