package com.human.admin.dto;

import com.human.admin.entity.Employee;
import com.human.admin.service.command.EmployeeCommand;

public class EmployeeDto {
    public Long id;

    public String name;

    public String email;

    public String phoneNumber;

    public String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeDto(){}
    public EmployeeDto(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
        this.address = employee.getAddress();
    }

    public EmployeeDto(EmployeeCommand command){
        this.id = command.getId();
        this.name = command.getName();
        this.phoneNumber = command.getPhoneNumber();
        this.email = command.getEmail();
        this.address = command.getAddress();
    }
}
