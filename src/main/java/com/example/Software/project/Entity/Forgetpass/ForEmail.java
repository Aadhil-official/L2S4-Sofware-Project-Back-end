package com.example.Software.project.Entity.Forgetpass;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


//forgot password email request entity to get the email separately
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ForEmail {
    @Email
    String email;
}
