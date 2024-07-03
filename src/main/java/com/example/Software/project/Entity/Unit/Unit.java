<<<<<<<< HEAD:src/main/java/com/example/backendArctic/Entity/Dto/FeedBackDto.java
package com.example.backendArctic.Entity.Dto;
========
package com.example.Software.project.Entity.Unit;
>>>>>>>> 4da3d1246e7f9dd5d272ddd52579f30213b78c36:src/main/java/com/example/Software/project/Entity/Unit/Unit.java

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
public class Unit {
    @Id
    private String id;

    @NotBlank
    private String indoorSerial;

    @NotBlank
    private String outdoorSerial;

    @NotBlank
    private String modelName;

    @NotBlank
    private String commissionedDate;

    @NotBlank
    private String owner;

    @NotBlank
    private String warrantyPeriod;

    @NotBlank
    private String unitPrice;

}
