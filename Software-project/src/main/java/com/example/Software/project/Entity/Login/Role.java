package com.example.Software.project.Entity.Login;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//Request body for login part
@Data
@Document(collection = "roles")
@NoArgsConstructor
public class Role {
    @Id
    private String id;
    private LogRole name;

//    private List<String> roles;
    public Role(LogRole name) {
        this.name = name;
    }
}
