package calendar.calendar.Events;

import org.springframework.data.mongodb.repository.MongoRepository;
// import calendar.calendar.Events.Event;

public interface EventRepository extends MongoRepository<Event, String> {
}
