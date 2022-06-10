package com.tom.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

    // PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String jobTitle;
    @Column
    private String phoneNumber;
    @Column
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String employeeCode;

    // CONSTRUCTORS

    public Employee() {
    }

    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String code) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phoneNumber = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = code;
    }

    // GETTERS & SETTERS

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String job) {
        this.jobTitle = job;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
    }

    public String getEmployeeCode() {
        return this.employeeCode;
    }

    public void setEmployeeCode(String code) {
        this.employeeCode = code;
    }

    // OTHER METHODS

    public String toString() {
        return "Employee{" +
                "id= " + id +
                ", name= " + name +
                ", email= " + email +
                ", jobTitle= " + jobTitle +
                ", phone= " + phoneNumber +
                ", imageUrl= " + imageUrl +
                "}";
    }
}
