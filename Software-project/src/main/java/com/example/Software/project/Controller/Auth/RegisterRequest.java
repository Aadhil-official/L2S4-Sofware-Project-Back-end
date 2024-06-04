package com.example.Software.project.Controller.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Data
public class RegisterRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 150)
//    @Pattern(regexp = "^[^@]+$", message = "Address must not be an email address")
    private String address;

    @NotBlank
    @Size(min = 1, max = 150)
    private String usergroup;

    @NotBlank
    @Size(max = 20)
//    @Pattern(regexp = "^\\+\\d{11}$")
    private String tel;

    private Set<String> roles;

    @NotBlank
    @Size(min = 8, max = 40)
    private String password = generatePassword();


    private String generatePassword() {
        Random random = new Random();
        int otpLength = 8;
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            pass.append(random.nextInt(10));
        }
        return pass.toString();
    }

}
