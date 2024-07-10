package com.example.Software.project.Entity.JobAllocationModule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "JobDetails")
public class JobDetailsEntity {

    @Id
    private String id;
    private String status;



}
