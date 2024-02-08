package com.example.employee.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class EmployeeDto {
    @Id
    private String userName;

    @NotEmpty @NotNull
    private String password;

    @NotNull
    private int age;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
