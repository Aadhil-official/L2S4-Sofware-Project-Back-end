package com.example.SpringMongoPoject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Employee {
    @Id
    private Integer employeeId;
    private String name;
    private String address;
    private String tel;
    private String email;
    private String password;
    private String confirmPassword;
    private String designation;
    private String userGroup;
}
