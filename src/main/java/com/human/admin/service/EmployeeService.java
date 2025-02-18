package com.human.admin.service;

import com.human.admin.service.command.EmployeeCommand;
import com.human.admin.vo.CommonResponseVo;

import java.util.List;

public interface EmployeeService {
    List<EmployeeCommand> retrieveAllEmployees(int page);

    EmployeeCommand findEmployeeById(Long id);

    EmployeeCommand updateEmployee(EmployeeCommand employeeCommand);

    EmployeeCommand registerEmployee(EmployeeCommand employeeCommand);

    CommonResponseVo removeEmployee(Long id);
}
