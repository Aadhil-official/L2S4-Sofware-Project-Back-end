package com.example.Software.project.Entity.Unit;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "units")
public class Unit {
    @Id
    private String id;

    @NotBlank
    private String indoorSerial;

    @NotBlank
    private String outdoorSerial;

    @NotBlank
    private String modelName;

    @NotBlank
    private String commissionedDate;

    @NotBlank
    private String owner;

    @NotBlank
    private String warrantyPeriod;

    @NotBlank
    private String unitPrice;

}
