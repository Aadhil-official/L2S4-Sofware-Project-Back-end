package com.example.Software.project.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class JobDto {
    private String id;
    private String itemIssue;
    private String customerDetails;
    private String employeeDetails;
    private String location;
    private String item;

}
