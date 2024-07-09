package com.example.Software.project.Controller.Reminder;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Software.project.Entity.Reminder.Reminder;
import com.example.Software.project.Repo.Reminder.ReminderRepository;
import com.example.Software.project.Service.Reminder.ReminderService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins= "*")
public class ReminderController {

    private final ReminderService reminderService;
    private ReminderRepository reminderRepository;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("/reminder")
    public List<Reminder> getAllEvents() {
        return reminderRepository.findAll();
    }

    @PostMapping("/createReminder")
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderService.saveReminder(reminder);
        
    }
}
