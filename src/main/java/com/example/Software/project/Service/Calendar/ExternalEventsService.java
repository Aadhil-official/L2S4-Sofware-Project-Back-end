package com.example.Software.project.Service.Calendar;

import org.springframework.stereotype.Service;

import com.example.Software.project.Entity.Calendar.ExternalEvents;
import com.example.Software.project.Repo.Calendar.ExternalEventsRepository;

import java.util.List;

@Service
public class ExternalEventsService {
    private final ExternalEventsRepository externalEventsRepository;

    public ExternalEventsService(ExternalEventsRepository externalEventsRepository) {
        this.externalEventsRepository = externalEventsRepository;
    }

    public List<ExternalEvents> getAllEvents() {
        return externalEventsRepository.findAll();
    }

}

