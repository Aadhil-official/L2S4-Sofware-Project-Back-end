package com.example.backendArctic.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class GatePassDto {

    private String id;
    @NotBlank
    private String vehicleNumber;
    @NotBlank
    private String groupName;
    @NotBlank
    private String customerName;


}
