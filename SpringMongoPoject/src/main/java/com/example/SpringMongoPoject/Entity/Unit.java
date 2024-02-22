package com.example.SpringMongoPoject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Unit {
    @Id
    private Integer serialNumber;
    private String modelName;
    private String owner;
    private String warrantyPeriod;
    private String unitPrice;
}
