package calendar.calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String description;
    private Date startTime;
    private Date endTime;

    // Constructors, getters, and setters
    public Event() {
    }

    public Event(String description, Date startTime, Date endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

