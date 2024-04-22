package com.example.Software.project.Entity.Complain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Complain {
    @Id
    private Integer complainId;
    private String subject;
    private String email;
    private String object;
    private String complaindate;
}
