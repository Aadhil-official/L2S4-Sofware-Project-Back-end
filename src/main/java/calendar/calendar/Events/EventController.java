package calendar.calendar.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    // private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody Event event) {
        Map<String, Object> response = new HashMap<>();
        
        if (event != null) {
            if ("none".equalsIgnoreCase(event.getRecurrenceFrequency())) {
                event.setRecurrenceFrequency(null);
                event.setRrule(null);
            } else {
                event.setRrule(generateRrule(event.getRecurrenceFrequency(), event.getStart()));
            }
            Event savedEvent = eventRepository.save(event);
            response.put("event", savedEvent);
        }
        
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable String id, @RequestBody Event updatedEvent) {
        return eventRepository.findById(id)
            .map(event -> {
                // Update event fields
                event.setTitle(updatedEvent.getTitle());
                event.setDescription(updatedEvent.getDescription());
                event.setStart(updatedEvent.getStart());
                event.setEnd(updatedEvent.getEnd());
                event.setAllDay(updatedEvent.isAllDay());
                event.setRecurrenceFrequency(updatedEvent.getRecurrenceFrequency());
                event.setRrule(updatedEvent.getRrule());

                return eventRepository.save(event);
            })
            .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventRepository.deleteById(id);
    }

    private String generateRrule(String frequency, Date startDate) {
        return "FREQ=" + frequency.toUpperCase() + ";DTSTART=" + new java.text.SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'").format(startDate);
    }
}
