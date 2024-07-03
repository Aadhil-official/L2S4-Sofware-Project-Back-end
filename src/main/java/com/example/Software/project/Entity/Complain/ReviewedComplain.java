package com.example.Software.project.Entity.Complain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviewedComplaints")
public class ReviewedComplain {
    @Id
    private String complainId;

    @NotBlank
    private String subject;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String object;

    @NotBlank
    private String complaindate;
}
