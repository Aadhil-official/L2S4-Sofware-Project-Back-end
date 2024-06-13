package com.example.dashboard.Items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Items {

    @Id
    private String id;

    public String getId() {
        return id;
    }
}
