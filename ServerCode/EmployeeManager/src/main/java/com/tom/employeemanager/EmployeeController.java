package com.tom.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tom.employeemanager.Services.EmployeeService;
import com.tom.employeemanager.model.Employee;

/*
 * @CrossOrigin enables CORS configuration for accepted origins.  
 * This lets different urls access our backent on localhost:8080
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeservice;

    public EmployeeController(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }

    /*
     * Returns an HTTP response of a list of employees with a status code
     */
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeservice.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /*
     * Returns an HTTP response of a single employee with a status code.
     * 
     * @PathVaraible takes part of the url path and converts it to an arguement in
     * the method.
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeservice.findEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /*
     * Handles POST requests and creates a new employee in the database. Returns an
     * HTTP response with the new employee and request status.
     * 
     * @RequestBody takes the body of the HTTP request and converts it to an
     * arguement in the method. Here it will take the JSON object and convert it to
     * an Employee object.
     */
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeservice.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    /*
     * Handles PUT requests and updates the employee.
     */
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeservice.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    /*
     * Handles DELETE requests and deletes the employee with the provided Id.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeservice.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
