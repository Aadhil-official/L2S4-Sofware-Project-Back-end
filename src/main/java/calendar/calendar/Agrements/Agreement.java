package calendar.calendar.Agrements;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Document(collection = "agreements")
public class Agreement {
    @Id
    private String id;
    // private String title;
    private Date date;
    private String type;
    private String companyName;
    
}

