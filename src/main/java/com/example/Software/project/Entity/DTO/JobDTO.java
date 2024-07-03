package com.example.Software.project.Entity.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class JobDTO {
    private String id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String itemIssue;

    @NotBlank
    private String customerDetails;

    @NotBlank
    private String employeeDetails;

    @NotBlank
    private String location;

    @NotBlank
    @Size(max = 10)
    private String item;
}
