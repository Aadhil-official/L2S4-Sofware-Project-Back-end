package com.example.backendArctic.Controller;

import com.example.backendArctic.Dto.AgreementServiceDto;
import com.example.backendArctic.Dto.ResponseDto;
import com.example.backendArctic.Entity.AgreementService;
import com.example.backendArctic.Entity.Job;
import com.example.backendArctic.Repo.AgreementServiceRepo;
import com.example.backendArctic.Repo.JobRepo;
import com.example.backendArctic.Service.AgreementServiceSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin (origins = "*" ,maxAge =3600)
@RestController
@RequestMapping("api/v1/agreementService")
public class AgreementServiceController {
    @Autowired
    private AgreementServiceSer agreementServiceSer;

    @Autowired
    private ResponseDto responseDto;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private AgreementServiceRepo agreementServiceRepo;

    public AgreementServiceController(AgreementServiceRepo agreementServiceRepo) {
        this.agreementServiceRepo = agreementServiceRepo;
    }


    @PutMapping("/updateAgreementService")
    public ResponseEntity<?> updateAgreementService(@RequestBody AgreementServiceDto agreementServiceDto) {
        try {
            Optional<AgreementService> optionalAgreementService = agreementServiceRepo.findById(agreementServiceDto.getId());
            if (optionalAgreementService.isPresent()) {
                AgreementService agreementService = optionalAgreementService.get();
                agreementService.setCustomerName(agreementServiceDto.getCustomerName());
                agreementService.setLocation(agreementServiceDto.getLocation());
                agreementService.setItem(agreementServiceDto.getItem());
                agreementService.setAgreementType(agreementServiceDto.getAgreementType());
                agreementService.setPeriodOfTheAgreement(agreementServiceDto.getPeriodOfTheAgreement());
                agreementServiceRepo.save(agreementService);
                return ResponseEntity.ok("Item updated successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + agreementServiceDto.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating item: " + e.getMessage());
        }
    }

    @PostMapping("/addServiceAgreement")
    public ResponseEntity<String> addServiceAgreement (@RequestBody AgreementService agreementService){
        try{
            agreementServiceRepo.save(agreementService);
            return ResponseEntity.status(HttpStatus.CREATED).body("Service AGreement Added Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "+ e);
        }
    }

    @PostMapping("/addNewServiceAgreement")
    public ResponseEntity<String> addNewServiceAgreement(@RequestBody AgreementService agreementService) {
        try {
            agreementServiceRepo.save(agreementService);

            // Create a corresponding job
            Job job = new Job();
            job.setItemIssue("Default issue for agreement " + agreementService.getId());
            job.setCustomerDetails(agreementService.getCustomerName());
            job.setEmployeeDetails("Default employee details");
            job.setLocation(agreementService.getLocation());
            job.setItem(agreementService.getItem());
            jobRepo.save(job);

            return ResponseEntity.status(HttpStatus.CREATED).body("Service Agreement and Job Added Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }




    @GetMapping("/getAgreementServiceTwo")
    public ResponseEntity<?> getAgreementServiceTwo(@RequestParam String id){
        try{

            Optional<AgreementService> agreementService =agreementServiceRepo.findById(id);
            return ResponseEntity.ok().body(agreementService);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:"+e.getMessage());
        }
    }

    @GetMapping("/getAgreementService")
    public ResponseEntity<AgreementService> getAgreementService(@RequestParam  String id) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping ("/deleteAgreementService")
    public void deleteAgreementService(@RequestParam String id) {
        agreementServiceRepo.deleteById(id);

    }
    @GetMapping("fetchAgreementService")
    public List<AgreementService> fetchAgreementService(){
        return  agreementServiceRepo.findAll();
    }

}

