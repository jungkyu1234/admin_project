package com.human.admin.presentation;


import com.human.admin.service.EmployeeService;
import com.human.admin.service.command.EmployeeCommand;
import com.human.admin.vo.CommonResponseVo;
import com.human.admin.vo.EmployeeVo;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("pageName", "어드민 인사관리 시스템");
        return "main";
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeVo>> getAllEmployees(@RequestParam int page){
        List<EmployeeCommand> employeeCommandList = employeeService.retrieveAllEmployees(page);

        if(CollectionUtils.isEmpty(employeeCommandList)){
            return ResponseEntity.noContent().build();
        }

        List<EmployeeVo> employeeVoList = employeeCommandList.stream()
                .map(EmployeeVo::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(employeeVoList);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeVo> getEmployee(@PathVariable Long id){
        EmployeeCommand employeeGetCommand = employeeService.findEmployeeById(id);
        if(employeeGetCommand == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new EmployeeVo(employeeGetCommand));
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeVo> registerNewEmployee(@RequestBody EmployeeVo employeeVo){
        EmployeeCommand employeeRegisterCommand = employeeService.registerEmployee(new EmployeeCommand(employeeVo));
        if(employeeRegisterCommand == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(new EmployeeVo(employeeRegisterCommand));
    }


    @PatchMapping("/employee")
    public ResponseEntity<EmployeeVo> updateNewEmployee(@RequestBody EmployeeVo employeeVo){
        EmployeeCommand employeeUpdateCommand = employeeService.updateEmployee(new EmployeeCommand(employeeVo));
        if(employeeUpdateCommand == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(new EmployeeVo(employeeUpdateCommand));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<CommonResponseVo> removeEmployee(@PathVariable Long id){
        CommonResponseVo commonResponseVo = employeeService.removeEmployee(id);
        return ResponseEntity.ok(commonResponseVo);
    }


}
