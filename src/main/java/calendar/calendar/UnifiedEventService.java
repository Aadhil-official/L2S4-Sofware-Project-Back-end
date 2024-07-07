package calendar.calendar;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import calendar.calendar.Events.Event;
import calendar.calendar.Events.EventRepository;
import calendar.calendar.ExternalEvents.ExternalEvents;
import calendar.calendar.ExternalEvents.ExternalEventsRepository;

@Service
public class UnifiedEventService {
    private final EventRepository eventRepository;
    private final ExternalEventsRepository externalEventsRepository;

    public UnifiedEventService(EventRepository eventRepository, ExternalEventsRepository externalEventsRepository) {
        this.eventRepository = eventRepository;
        this.externalEventsRepository = externalEventsRepository;
    }

    public List<Object> getAllUnifiedEvents() {
        List<Event> events = eventRepository.findAll();
        List<ExternalEvents> externalEvents = externalEventsRepository.findAll();

        List<Object> unifiedEvents = new ArrayList<>();

        // Convert events to EventDTO
        for (Event event : events) {
            EventDTO eventDTO = new EventDTO(
                event.getTitle(), 
                event.getDescription(), 
                event.getStart(), 
                event.getEnd(), 
                event.isAllDay(),
                event.isForever()
            );
            unifiedEvents.add(eventDTO);
        }

        // Convert external events to ExternalEventDTO
        for (ExternalEvents externalEvent : externalEvents) {
            ExternalEventDTO externalEventDTO = new ExternalEventDTO(
                externalEvent.getCompanyName(), 
                externalEvent.getIssue(),
                externalEvent.getDate()
            );
            unifiedEvents.add(externalEventDTO);
        }

        return unifiedEvents;
    }
}
