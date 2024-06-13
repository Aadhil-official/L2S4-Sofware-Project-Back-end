package com.example.dashboard.Jobs;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class Jobs {

    @Id
    private String id;

    public String getId() {
        return id;
    }
}