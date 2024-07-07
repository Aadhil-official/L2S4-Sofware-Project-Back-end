package calendar.calendar.Visits;

import java.time.LocalDateTime;
import java.time.Month;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "visits")
public class Visits {

    @Id
    private String id;
    private String status;
    private LocalDateTime date;
    private Month month;


    public String getId() {
        return id;
    }

    public String getStatus(){
        return status;
    }

    public LocalDateTime getDate() {
            return date;
        }

    public Month getMonth() {
            return month;
        }
}
