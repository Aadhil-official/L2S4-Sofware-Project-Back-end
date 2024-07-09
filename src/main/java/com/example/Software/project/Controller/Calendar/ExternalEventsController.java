package com.example.Software.project.Controller.Calendar;

import org.springframework.web.bind.annotation.*;

import com.example.Software.project.Entity.Calendar.ExternalEvents;
import com.example.Software.project.Repo.Calendar.ExternalEventsRepository;
import com.example.Software.project.Service.Calendar.ExternalEventsService;

import java.util.List;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("/api/auth")
public class ExternalEventsController {
    private final ExternalEventsRepository externalEventsRepository;
    private final ExternalEventsService externalEventsService;

    public ExternalEventsController(ExternalEventsRepository externalEventsRepository, ExternalEventsService ExternalEventsService) {
        this.externalEventsRepository = externalEventsRepository;
        this.externalEventsService = ExternalEventsService;
    }

    @GetMapping("/jobEvents")
    public List<ExternalEvents> getAllEvents() {
        return externalEventsService.getAllEvents();
    }

    // @GetMapping("/{id}")
    // public ExternalEvents getEventById(@PathVariable String id) {
    //     return externalEventsRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    // }

    
    
}
