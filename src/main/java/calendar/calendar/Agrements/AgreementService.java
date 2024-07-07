package calendar.calendar.Agrements;


import org.springframework.stereotype.Service;

// import calendar.calendar.ExternalEvents.ExternalEvents;
// import calendar.calendar.ExternalEvents.ExternalEventsRepository;

import java.util.List;

@Service
public class AgreementService {
    private final AgreementRepository agreementRepository;

    public AgreementService(AgreementRepository externalEventsRepository) {
        this.agreementRepository = externalEventsRepository;
    }

    public List<Agreement> getAllEvents() {
        return agreementRepository.findAll();
    }

}
