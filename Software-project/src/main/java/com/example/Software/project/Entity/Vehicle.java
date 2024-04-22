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
public class Vehicle {
    @Id
    private Integer vehicleId;
    private String vehicleType;
    private String vehicleNumber;
    private String NoOfPassengers;
}
