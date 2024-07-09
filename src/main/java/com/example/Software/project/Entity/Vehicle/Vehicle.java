package com.example.Software.project.Entity.Vehicle;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "vehicles")  
public class Vehicle {
    @Id
    private String id;

    @NotBlank
    private String vehicleType;

    @NotBlank
    private String vehicleNumber;


    @NotBlank
    private String noOfPassengers;

}
