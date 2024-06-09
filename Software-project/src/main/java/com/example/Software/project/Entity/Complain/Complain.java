package com.example.Software.project.Entity.Complain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//The complaints request entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "complaints")
public class Complain {
    @Id
    private String complainId;
    private String subject;
    private String email;
    private String object;
    private String complaindate;
}
