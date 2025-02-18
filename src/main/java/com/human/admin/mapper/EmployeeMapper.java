package com.human.admin.mapper;


import com.human.admin.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<EmployeeDto> findAll(int row);

    void deleteEmployee(long id);

    void updateEmployee(EmployeeDto employeeDto);
}
