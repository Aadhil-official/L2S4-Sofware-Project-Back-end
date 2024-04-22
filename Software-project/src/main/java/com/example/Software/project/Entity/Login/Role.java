package com.example.Software.project.Entity.Login;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private LogRole name;

    public Role(LogRole name) {
        this.name = name;
    }
}
