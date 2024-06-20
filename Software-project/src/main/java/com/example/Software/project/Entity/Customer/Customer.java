package com.example.Software.project.Entity.Customer;

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
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;

    @NotBlank
    private String customerName;

    @NotBlank
    private String address;

    @NotBlank
    private String contactNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String location;
}
