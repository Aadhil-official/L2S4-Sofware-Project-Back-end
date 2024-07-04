package com.example.backendArctic.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "End_Dates")
public class EndDates {

    @Id
    private String id;
    private Date endDate;
    private String visitId;
    private String location;

    public EndDates() {
        // Default constructor
    }

    public EndDates(Date endDate, String visitId, String location) {
        this.endDate = endDate;
        this.visitId = visitId;
        this.location = location;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }
}
