package com.human.admin.dao.employee;

import com.human.admin.dto.EmployeeDto;

import java.util.List;

public interface EmployeeDao {
    List<EmployeeDto> findAll(int page);

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto findById(Long id);

    EmployeeDto modify(EmployeeDto employeeDto);

    boolean remove(Long id);
}
