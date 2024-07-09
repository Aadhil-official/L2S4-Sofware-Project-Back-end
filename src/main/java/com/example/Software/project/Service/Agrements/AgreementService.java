package com.example.Software.project.Service.Agrements;


import org.springframework.stereotype.Service;

import com.example.Software.project.Entity.Agrements.Agreement;
import com.example.Software.project.Repo.Agrements.AgreementRepository;

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
