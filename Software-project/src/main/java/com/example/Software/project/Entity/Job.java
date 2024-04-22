package com.example.Software.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Job {
    @Id
    private Integer jobId;
    private String itemIssue;
    private String customerDetails;
    private String employeeDetails;
    private String location;
    private String item;
}
