package com.example.Software.project.Entity.DTO;

import com.example.Software.project.Entity.Unit.Unit;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class UnitDTO {

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
