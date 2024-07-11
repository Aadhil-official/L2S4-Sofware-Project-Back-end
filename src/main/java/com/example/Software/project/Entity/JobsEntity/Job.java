package com.example.Software.project.Entity.JobsEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Job")
public class Job {
    @Id
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
