package com.example.Software.project.Repo.Reminder;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Software.project.Entity.Reminder.Reminder;

public interface ReminderRepository extends MongoRepository<Reminder, String> {
}