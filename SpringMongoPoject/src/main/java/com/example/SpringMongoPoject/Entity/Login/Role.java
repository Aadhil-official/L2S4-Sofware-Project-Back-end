package com.example.SpringMongoPoject.Entity.Login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Role {
    @Id
    private String id;
    private LogRole name;

    public Role(LogRole name) {
        this.name = name;
    }
}
