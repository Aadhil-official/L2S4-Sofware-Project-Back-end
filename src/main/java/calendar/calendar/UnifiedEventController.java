//Take data from two collections and returns after combining them together

package calendar.calendar;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;


// UnifiedEventController.java
@RestController
@RequestMapping("/api/events")
public class UnifiedEventController {
    private final UnifiedEventService unifiedEventService;

    public UnifiedEventController(UnifiedEventService unifiedEventService) {
        this.unifiedEventService = unifiedEventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Object>> getAllUnifiedEvents() {
        List<Object> unifiedEvents = unifiedEventService.getAllUnifiedEvents();
        return ResponseEntity.ok(unifiedEvents);
    }
}
