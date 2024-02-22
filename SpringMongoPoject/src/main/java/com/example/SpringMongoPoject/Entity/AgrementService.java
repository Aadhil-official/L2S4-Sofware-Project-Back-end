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
public class AgrementService {
    @Id
    private Integer agrmntServiceId;
    private String customerDetails;
    private String location;
    private String item;
    private String agreementType;
    private String periodOfTheAgreement;
}
