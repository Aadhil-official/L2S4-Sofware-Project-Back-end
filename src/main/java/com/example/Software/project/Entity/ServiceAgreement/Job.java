package com.example.Software.project.Entity.ServiceAgreement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Job_Details")
public class Job {
    @Id
    private String id;
    private String itemIssue;
    private String customerDetails;
    private String employeeDetails;
    private String location;
    private String item;
}
