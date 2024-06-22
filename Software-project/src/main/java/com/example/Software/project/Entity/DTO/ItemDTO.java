package com.example.Software.project.Entity.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ItemDTO {
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String indoorMod;

    @NotBlank
    private String outdoorMod;

    @NotBlank
    private String manufacturer;

    @NotBlank
    @Size(max = 30)
    private String capacity;
}
