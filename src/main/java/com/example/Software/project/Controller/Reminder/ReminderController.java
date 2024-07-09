package com.example.Software.project.Controller.Reminder;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Software.project.Entity.Reminder.Reminder;
import com.example.Software.project.Repo.Reminder.ReminderRepository;
import com.example.Software.project.Service.Reminder.ReminderService;

@RestController
@RequestMapping("/api/reminders")
@CrossOrigin(origins= "*")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;
    private ReminderRepository reminderRepository;

      @GetMapping
    public List<Reminder> getAllEvents() {
        return reminderRepository.findAll();
    }

    @PostMapping
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderService.saveReminder(reminder);
        
    }
}
