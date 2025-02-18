package com.human.admin.dao.employee;


import com.human.admin.dto.EmployeeDto;
import com.human.admin.entity.Employee;
import com.human.admin.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
public class EmployeeEntityDao implements EmployeeDao{

    private final EmployeeRepository employeeRepository;

    public EmployeeEntityDao(EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").descending());
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        return employeePage.stream().map(EmployeeDto::new).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            EmployeeDto employeeDto = new EmployeeDto(employeeOptional.get());
            return employeeDto;
        }
        return null;
    }

    @Override
    public EmployeeDto modify(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeDto.getId());
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setName(employeeDto.getName());
            employee.setEmail(employeeDto.getEmail());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
            return new EmployeeDto(employee);
        }
        return null;
    }

    @Override
    public boolean remove(Long id) {
        if(!employeeRepository.existsById(id)){
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(new Employee(employeeDto));
        return new EmployeeDto(employee);
    }
}
