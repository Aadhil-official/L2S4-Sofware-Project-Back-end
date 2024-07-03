package com.example.backendArctic.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Cancel_Dates")
public class CancelDates {

    @Id
    private String id;
    private Date clickDate;
    private String visitId;
    private String location;

    public CancelDates() {
        // Default constructor
    }

    public CancelDates(Date clickDate, String visitId, String location) {
        this.clickDate = clickDate;
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

    public Date getClickDate() {
        return clickDate;
    }

    public void setClickDate(Date clickDate) {
        this.clickDate = clickDate;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
