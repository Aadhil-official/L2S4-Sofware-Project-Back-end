package calendar.calendar.Reminder;


// src/main/java/com/example/reminder/Reminder.java
// package com.example.reminder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "reminders")
public class Reminder {
    @Id
    private String id;
    private String email;
    private String title;
    private String startTime;
    private String endTime;
    private String reminderTime;

    // Getters and setters
}
