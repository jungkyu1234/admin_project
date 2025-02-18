package com.human.admin.vo;

import com.human.admin.service.command.EmployeeCommand;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeVo {
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

    public EmployeeVo(){}

    public EmployeeVo(EmployeeCommand employeeCommand){
        this.id = employeeCommand.getId();
        this.name = employeeCommand.getName();
        this.email = employeeCommand.getEmail();
        this.phoneNumber = employeeCommand.getPhoneNumber();
        this.address = employeeCommand.getAddress();
    }
}
