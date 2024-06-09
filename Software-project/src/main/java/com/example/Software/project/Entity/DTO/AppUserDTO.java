package com.example.Software.project.Entity.DTO;

import com.example.Software.project.Entity.Login.Role;
import jakarta.validation.constraints.Pattern;
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
    private String username;
    private String address;

    @Pattern(regexp = "^\\+\\d{11}$", message = "Invalid telephone number")
    private String tel;

    @DBRef
    private Set<Role> roles = new HashSet<>();

}
