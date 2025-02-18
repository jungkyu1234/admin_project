package com.human.admin.service;

import com.human.admin.dao.employee.EmployeeDao;
import com.human.admin.dto.EmployeeDto;
import com.human.admin.repository.EmployeeRepository;
import com.human.admin.service.command.EmployeeCommand;
import com.human.admin.vo.CommonResponseVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmployeeCommand> retrieveAllEmployees(int page) {
        List<EmployeeDto> employeeDtoList = employeeDao.findAll(page);
        return employeeDtoList.stream()
                .map(EmployeeCommand::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public EmployeeCommand findEmployeeById(Long id) {
        EmployeeDto employeeDto = employeeDao.findById(id);
        if(employeeDto != null){
            return new EmployeeCommand(employeeDto);
        }
        return null;
    }

    @Transactional
    @Override
    public EmployeeCommand updateEmployee(EmployeeCommand employeeCommand) {
        EmployeeDto employeeDto = employeeDao.modify(new EmployeeDto(employeeCommand));
        if(employeeDto != null){
            return new EmployeeCommand(employeeDto);
        }
        return null;
    }

    @Transactional
    @Override
    public EmployeeCommand registerEmployee(EmployeeCommand employeeCommand) {
        EmployeeDto employeeDto = employeeDao.save(new EmployeeDto(employeeCommand));
        if(employeeDto != null){
            return new EmployeeCommand(employeeDto);
        }
        return null;
    }

    @Transactional
    @Override
    public CommonResponseVo removeEmployee(Long id) {
        if(employeeDao.remove(id)){
            return CommonResponseVo.builder().status(200)
                    .message("removed")
                    .build();
        }
        return CommonResponseVo.builder().status(500)
                .message("not removed")
                .build();
    }
}
