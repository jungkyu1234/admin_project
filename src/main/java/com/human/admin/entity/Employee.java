package com.human.admin.entity;


import com.human.admin.dto.EmployeeDto;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "employee_name")
    public String name;

    @Column(name = "employee_email")
    public String email;

   @Column(name="phone_number")
    public String phoneNumber;

   @Column(name = "address")
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

    public Employee(){}
    public Employee(EmployeeDto employeeDto){
        this.name = employeeDto.getName();
        this.phoneNumber = employeeDto.getPhoneNumber();
        this.email = employeeDto.getEmail();
        this.address = employeeDto.getAddress();
    }
}
