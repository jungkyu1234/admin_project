package com.human.admin.service.command;


import com.human.admin.dto.EmployeeDto;
import com.human.admin.vo.EmployeeVo;
import io.micrometer.common.util.StringUtils;

public class EmployeeCommand {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

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

    public EmployeeCommand(){}

    public EmployeeCommand(EmployeeDto employeeDto){
        this.id = employeeDto.getId();
        this.name = employeeDto.getName();
        this.email = employeeDto.getEmail();
        this.phoneNumber = employeeDto.getPhoneNumber();
        this.address = employeeDto.getAddress();
    }

    public EmployeeCommand(EmployeeVo employeeVo){
        if(employeeVo.getId() != null){
          this.id = employeeVo.getId();
        }
        if(StringUtils.isNotEmpty(employeeVo.getName())){
            this.name = employeeVo.getName();
        }
        if(StringUtils.isNotEmpty(employeeVo.getEmail())) {
            this.email = employeeVo.getEmail();
        }
        if(StringUtils.isNotEmpty(employeeVo.getPhoneNumber())) {
            this.phoneNumber = employeeVo.getPhoneNumber();
        }
        if(StringUtils.isNotEmpty(employeeVo.getAddress())) {
            this.address = employeeVo.getAddress();
        }
    }


}
