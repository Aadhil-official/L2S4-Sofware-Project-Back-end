package calendar.calendar.ExternalEvents;

// Importing necessary Spring Boot annotations and classes
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


// Annotation indicating that this interface is a Spring Data repository
@Repository
public interface ExternalEventsRepository extends MongoRepository<ExternalEvents, String> {
    
}
