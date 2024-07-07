package calendar.calendar.Jobs;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "jobs")
public class Jobs {

    @Id
    private String id;
    private String status;
    private LocalDateTime date;
   
}