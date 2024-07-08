package com.example.Software.project.Entity.Units;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "units")
public class Units {
    
    @Id
    protected String id;

    public String getId() {
        return id;
    }
}

