package calendar.calendar;

import java.util.Date;

public class EventDTO {
    private String title;
    private String description;
    private Date start;
    private Date end;
    private boolean allDay;
    private boolean forever;

    public EventDTO(String title, String description, Date start, Date end, boolean allDay, boolean forever){
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.allDay = allDay;
        this.forever = forever;
    }

    public EventDTO() {
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

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public boolean isForever() {
        return forever;
    }

    public void setForever(boolean forever) {
        this.forever = forever;
    }
}
