package com.example.dashboard.Customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customers {

    @Id
    private String id;

    public String getId() {
        return id;
    }
}
