package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.exceptionHandler.EmployeeNotFoundException;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<Object> getEmployeeDetails(String userName){
        Optional<EmployeeModel> data = Optional.ofNullable(employeeRepository.findByUserName(userName));
        if (data==null){
            throw new EmployeeNotFoundException("Employee not found with the given ID.");
        }
        return ResponseEntity.ok(data);
    }

    public ResponseEntity<Object> updateEmploye(EmployeeDto data){
        EmployeeModel employeeData = modelMapper.map(data, EmployeeModel.class);
        return new  ResponseEntity<>(employeeRepository.save(employeeData),  new HttpHeaders(), HttpStatus.OK);
    }

    public ResponseEntity deleteEmpById(String userName){
        EmployeeModel data = employeeRepository.deleteByUserName(userName);
        if (data==null){
            throw new EmployeeNotFoundException("Employee not found with the given ID.");
        }
        return ResponseEntity.ok("deleted");
    }

    public ResponseEntity<Object> createEmployee(EmployeeDto data){
        System.out.println("getting username here: " + "userName");
        EmployeeModel userData = modelMapper.map(data, EmployeeModel.class);
        System.out.println(userData);
        return new ResponseEntity<>(employeeRepository.save(userData), new HttpHeaders(), HttpStatus.OK);
//        return null;
    }
}
