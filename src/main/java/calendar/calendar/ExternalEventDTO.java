package calendar.calendar;

import java.util.Date;

public class ExternalEventDTO {
    private String title; // Company name
    private String description; // Issue
    private Date start; // Date
    private boolean allDay = true; // All-day event, as per your requirement

    public ExternalEventDTO(String title, String description, Date start) {
        this.title = title;
        this.description = description;
        this.start = start;
    }

    public ExternalEventDTO() {
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }
}

