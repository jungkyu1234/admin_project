package com.human.admin.dao.employee;

import com.human.admin.dto.EmployeeDto;
import com.human.admin.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //자동으로 생성자 만들어줌
public class EmployeeMapperDao implements EmployeeDao{

    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> findAll(int page) {
        int row = 5 * (page);
        return employeeMapper.findAll(row);
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto findById(Long id) {
        return null;
    }

    @Override
    public EmployeeDto modify(EmployeeDto employeeDto) {
         employeeMapper.updateEmployee(employeeDto);
         return employeeDto;

    }

    @Override
    public boolean remove(Long id) {
       employeeMapper.deleteEmployee(id);

        return true;
    }
}
