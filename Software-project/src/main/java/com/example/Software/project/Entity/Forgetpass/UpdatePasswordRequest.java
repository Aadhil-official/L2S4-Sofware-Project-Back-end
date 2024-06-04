package com.example.Software.project.Entity.Forgetpass;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

//Update password request entity (for forget password)
@Data //to make all setters and getters
@AllArgsConstructor //for build the all args constructor
@NoArgsConstructor //for build the all args constructor
@Document //to make collection
public class UpdatePasswordRequest {
    @Email
    String email;
    String otp;
    String newPassword;
}
