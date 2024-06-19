package com.example.Software.project.Entity.Jobs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Job {
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
    @Size(max = 10)
    private String item;
}
