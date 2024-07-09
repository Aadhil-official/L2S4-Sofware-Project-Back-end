package com.example.Software.project.Repo.Calendar;

import org.springframework.data.mongodb.repository.MongoRepository;
// import calendar.calendar.Events.Event;

import com.example.Software.project.Entity.Calendar.Event;

public interface EventRepository extends MongoRepository<Event, String> {
}
