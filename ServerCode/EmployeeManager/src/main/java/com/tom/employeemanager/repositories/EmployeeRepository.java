package com.tom.employeemanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.tom.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // TODO: unsure why but for now this method causes a 500 Error HTTP response
    // when trying to delete user by Id. For now just use .deleteById in
    // EmployeeService
    // @Query("DELETE e FROM employeemanager e WHERE e.id = ?1")
    void deleteEmployeeById(Long id);

    // @Query("SELECT e FROM employeemanager e WHERE e.id = ?1")
    Optional<Employee> findEmployeeById(Long id);
}
