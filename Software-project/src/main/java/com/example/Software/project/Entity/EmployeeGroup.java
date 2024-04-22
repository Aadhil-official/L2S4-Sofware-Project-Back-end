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
public class EmployeeGroup {
    @Id
    private Integer userGroupID;
    private String name;
    private String description;
    private String privileges;
    private String allocatedJobs;
}
