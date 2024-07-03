package com.example.Software.project.Controller.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthonticationRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
