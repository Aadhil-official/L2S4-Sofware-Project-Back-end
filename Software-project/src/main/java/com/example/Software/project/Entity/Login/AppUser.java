package com.example.Software.project.Entity.Login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;


//request body for appuser
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "appUser") //to map the instances
public class AppUser {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
//    @Pattern(regexp = "^\\+\\d{11}$")
    private String tel;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 150)
    private String address;

    @NotBlank
    @Size(max = 150)
    private String usergroup;

    @DBRef
    private Set<Role> roles = new HashSet<>();


    public AppUser(String username, String email, String address, String usergroup, String tel ,String password) {
        this.username = username;
        this.email = email;
        this.address=address;
        this.usergroup=usergroup;
        this.tel=tel;
        this.password = password;
    }
}
