package com.example.Software.project.Repo.Calendar;


// Importing necessary Spring Boot annotations and classes
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Software.project.Entity.Calendar.ExternalEvents;


// Annotation indicating that this interface is a Spring Data repository
@Repository
public interface ExternalEventsRepository extends MongoRepository<ExternalEvents, String> {
    
}
