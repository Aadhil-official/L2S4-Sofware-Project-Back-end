package com.example.Software.project.Entity.Calendar;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Document(collection = "jobs")
public class ExternalEvents {
    private String id;
    private String companyName;
    private String issue;
    private Date date;
    

}