package com.example.employee.service;

import com.example.employee.dto.UserDto;
import com.example.employee.model.UserModel;
import com.example.employee.repository.UserRepository;
import com.example.employee.utils.JwtUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JwtUtils jwtUtils;

@Autowired
UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;
    public ResponseEntity<?> createUser(UserDto data){
        UserModel userData = modelMapper.map(data, UserModel.class);
        return new  ResponseEntity<>(userRepository.save(userData),  new HttpHeaders(), HttpStatus.OK);
    }
    public ResponseEntity<String> generateToken(UserDto data){
        String name = data.getUserName();
        if (userRepository.existsByUserName(name)){
            return new ResponseEntity<>(jwtUtils.generateTokenFromUsername(name),new HttpHeaders(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User Not Found",new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }
}
