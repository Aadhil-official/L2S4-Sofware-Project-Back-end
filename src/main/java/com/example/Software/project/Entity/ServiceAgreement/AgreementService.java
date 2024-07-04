package com.example.backendArctic.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document (collection = "Agreement_service")
public class AgreementService {
    @Id
    private String id;
    @NotBlank
    private String customerName;
    @NotBlank
    private String location;
    @NotBlank
    private String item;
    @NotBlank
    private String agreementType;
    @NotBlank
    private String periodOfTheAgreement;
    @NotBlank
    private Date startDate;
    @NotBlank
    private Date endDate;


}
