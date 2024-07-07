package calendar.calendar.Vehicles;

// Vehicles.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class Vehicles {

    @Id
    private String id;

    public String getId() {
        return id;
    }

   
}