package com.example.Software.project.Entity.ServiceAgreement;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "services")
public class ServiceAgreement {
    @Id
    private String id;

    @NotBlank
    private String cusName;

    @NotBlank
    private String location;

    @NotBlank
    private String item;

    @NotBlank
    private String agrType;

    @NotBlank
    private String periMonth;
}
