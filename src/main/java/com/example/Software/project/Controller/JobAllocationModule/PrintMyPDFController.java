package com.example.Software.project.Controller.JobAllocationModule;


import com.example.Software.project.Entity.JobAllocationModule.PrintPDFEntity;
import com.example.Software.project.Repo.JobAllocationModule.PrintPDFRepo;

import com.example.Software.project.Service.JobAllocationModule.PdfService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class PrintMyPDFController {

    private final PrintPDFRepo jobsRepo;

    private final PdfService pdfService;

    @Autowired
    public PrintMyPDFController(PrintPDFRepo jobsRepo,PdfService pdfService) {
        this.jobsRepo = jobsRepo;

        this.pdfService = pdfService;
    }


    @GetMapping("/addnewJob")
    public ResponseEntity<?> getJobById(@PathVariable String id) {
        Optional<PrintPDFEntity> pdf = jobsRepo.findById(id);
        if (pdf.isPresent()) {
            return ResponseEntity.ok(pdf.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found");
        }
    }


}
