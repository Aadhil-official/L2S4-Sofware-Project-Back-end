package com.example.Software.project.Entity.Complain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//The complaints request entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "complaints")
public class Complain {
    @Id
    private String complainId;

    @NotBlank
    @Size(max = 150)
    private String subject;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String object;

    @NotBlank
    private String complaindate;
}
