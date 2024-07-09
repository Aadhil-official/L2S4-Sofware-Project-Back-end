package com.example.Software.project.Controller.Agrements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Software.project.Entity.Agrements.Agreement;
import com.example.Software.project.Repo.Agrements.AgreementRepository;

import java.util.List;

@RestController
@RequestMapping("/aggrements")
public class AgreementController {

    @Autowired
    private AgreementRepository agreementRepository;

    @GetMapping
    public List<Agreement> getAllAgreements() {
        return agreementRepository.findAll();
    }

 }

