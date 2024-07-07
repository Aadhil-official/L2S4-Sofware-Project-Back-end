package calendar.calendar.Reminder;

// src/main/java/com/example/reminder/ReminderRepository.java
// package com.example.reminder;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReminderRepository extends MongoRepository<Reminder, String> {
}
