package com.example.Software.project.Entity.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAgrementDTO {

    private String cusName;

    private String location;

    private String item;

    private String agrType;
}
