package com.example.employee.controller;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/EmployeeDetail")
    public ResponseEntity<Object> getEmployeeDetails(@RequestParam String userName){
        System.out.println(userName);
        return employeeService.getEmployeeDetails(userName);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDto data){
        return employeeService.createEmployee(data);
    }

    @PutMapping("/updateEmployee")
    private ResponseEntity<Object> updateEmploye(@RequestBody @Valid EmployeeDto data){
        return employeeService.updateEmploye(data);
    }

    @DeleteMapping("/deleteEmployee")
    private ResponseEntity deleteEmpById(@RequestParam(required = true) String userName){
        return employeeService.deleteEmpById(userName);
    }
}
