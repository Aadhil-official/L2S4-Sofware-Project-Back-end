package calendar.calendar.Events;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

// import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String title;
    private String description;
    private Date start;
    private Date end;
    private boolean allDay;
    private boolean isForever;
    private String recurrenceFrequency;
    private String rrule;
 

}
