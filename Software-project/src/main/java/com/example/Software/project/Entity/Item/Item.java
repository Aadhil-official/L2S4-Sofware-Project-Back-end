package com.example.Software.project.Entity.Item;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Item {
    @Id
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
    private String capacity;

}
