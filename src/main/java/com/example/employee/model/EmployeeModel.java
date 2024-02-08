package com.example.employee.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Configuration
public class EmployeeModel {

    @Id
    private String userName;

    @NotNull @NotEmpty
    private String password;

    @NotNull
    private int age;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
