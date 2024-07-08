package com.example.Software.project.Entity.DTO;

import com.example.Software.project.Entity.Login.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class AppUserDTO {
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 12,min = 10)
    @Pattern(regexp = "^\\+?\\d{10,12}$", message = "Invalid telephone number")
    private String tel;

    @NotBlank
    @Size(max = 150)
    private String address;

    @NotBlank
    @Size(max = 150)
    private String usergroup;

    private Set<Role> roles;

}
