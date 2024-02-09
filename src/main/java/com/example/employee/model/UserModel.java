package com.example.employee.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Configuration
public class UserModel {
    @Id
    private String userName;

    @NotNull
    @NotEmpty
    private String password;
}
