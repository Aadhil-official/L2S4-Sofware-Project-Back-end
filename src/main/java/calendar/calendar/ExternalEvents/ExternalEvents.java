package calendar.calendar.ExternalEvents;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;


@Document(collection = "jobs")
public class ExternalEvents {
    private String id;
    private String companyName;
    private String issue;
    private Date date;
    

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getIssue() {
        return issue;
    }

    public Date getDate() {
        return date;
    }

}
