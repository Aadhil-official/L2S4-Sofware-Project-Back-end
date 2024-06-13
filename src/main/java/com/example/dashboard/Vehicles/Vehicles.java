package com.example.dashboard.Vehicles;

// Vehicles.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class Vehicles {

    @Id
    private String id;
    private String Vehicle_type;

    public String getId() {
        return id;
    }

    public String getVehicle_type() {
        return Vehicle_type;
    }
}

