package calendar.calendar.ExternalEvents;


import org.springframework.stereotype.Service;


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
