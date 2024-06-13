package com.example.dashboard.Employees;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employees {

    @Id
    private String id;
    private String JOB_ID;

    public String getId() {
        return id;
    }

    public String getJOB_ID(){
        return JOB_ID;
    }
}
