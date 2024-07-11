package com.example.Software.project.Dto.JOBSDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class JobsDTO {

    private String id;

    @NotBlank
    private String vehicleNumber;

    @NotBlank
    private String status;

    @NotBlank
    private String customerName;

    @NotBlank
    private String date;

    @NotEmpty
    private List<String> teamMembers ;

}
