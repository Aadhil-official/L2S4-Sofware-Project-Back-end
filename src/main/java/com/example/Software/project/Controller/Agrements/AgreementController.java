package com.example.Software.project.Controller.Agrements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Software.project.Entity.Agrements.Agreement;
import com.example.Software.project.Repo.Agrements.AgreementRepository;

import java.util.List;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("/api/auth")
public class AgreementController {

   private final AgreementRepository agreementRepository;

   public AgreementController(AgreementRepository agreementRepository) {
       this.agreementRepository = agreementRepository;
   }

   @GetMapping("/getAgreementEvent")
   public List<Agreement> getAllAgreements() {
       return agreementRepository.findAll();
   }

}

