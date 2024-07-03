<<<<<<<< HEAD:src/main/java/com/example/backendArctic/Entity/Dto/AgreementServiceDto.java
package com.example.backendArctic.Entity.Dto;
========
package com.example.Software.project.Entity.ServiceAgreement;
>>>>>>>> 4da3d1246e7f9dd5d272ddd52579f30213b78c36:src/main/java/com/example/Software/project/Entity/ServiceAgreement/ServiceAgreement.java

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
