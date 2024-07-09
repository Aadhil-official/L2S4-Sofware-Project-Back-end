package com.example.Software.project.Entity.JobAllocationModule;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Job")
public class JobEntity {
    @Id
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
    @Size(max=10)
    private String item;

}
