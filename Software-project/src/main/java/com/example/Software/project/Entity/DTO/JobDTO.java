package com.example.Software.project.Entity.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

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
