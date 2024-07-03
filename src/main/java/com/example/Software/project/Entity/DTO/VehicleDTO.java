<<<<<<<< HEAD:src/main/java/com/example/backendArctic/Entity/Dto/GatePassDto.java
package com.example.backendArctic.Entity.Dto;

========
package com.example.Software.project.Entity.DTO;
>>>>>>>> 4da3d1246e7f9dd5d272ddd52579f30213b78c36:src/main/java/com/example/Software/project/Entity/DTO/VehicleDTO.java

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class VehicleDTO {
    private String id;

    @NotBlank
    private String vehicleType;

    @NotBlank
    private String vehicleNumber;


    @NotBlank
    private String noOfPassengers;
}
