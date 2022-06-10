package com.tom.employeemanager.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.employeemanager.exceptions.UserNotFoundException;
import com.tom.employeemanager.model.Employee;
import com.tom.employeemanager.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeerepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeerepository) {
        this.employeerepository = employeerepository;
    }

    /*
     * Takes an Employee object, autogenerates a UUID code, and uses the
     * JpaRepository methods to save the employee to the database.
     */
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeerepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeerepository.findAll();
    }

    // TODO: When updating an employee from the UI form, the employeeCode gets reset
    // to null
    public Employee updateEmployee(Employee employee) {
        return employeerepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeerepository.deleteById(id);
    }

    public Employee findEmployee(Long id) {
        return employeerepository.findEmployeeById(id).orElseThrow(
                () -> new UserNotFoundException("User with this Id does not exist."));
    }
}
