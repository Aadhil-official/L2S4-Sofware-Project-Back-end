package com.example.Software.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {
 @Id
    private Integer customId;
    private String name;
    private String address;
    private String tel;
    private String email;
    private String location;
}
