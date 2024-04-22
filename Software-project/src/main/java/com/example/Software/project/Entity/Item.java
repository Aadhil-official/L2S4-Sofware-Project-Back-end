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
public class Item {
    @Id
    private Integer itemId;
    private String name;
    private String indoorModel;
    private String outdoorModel;
    private String manufacture;
    private String capacity;
}
