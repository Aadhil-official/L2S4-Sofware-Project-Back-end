package com.example.Software.project.Entity.Forgetpass;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Update password request entity (for forget password)
@Data //to make all setters and getters
@AllArgsConstructor //for build the all args constructor
@NoArgsConstructor //for build the all args constructor
@Document //to make collection
public class UpdatePasswordRequest {
    @Email
    @NotBlank
    String email;

    @NotBlank
    @Size(min = 6, max = 6)
    String otp;

    @NotBlank
    @Size(min = 8)
    String newPassword;
}
