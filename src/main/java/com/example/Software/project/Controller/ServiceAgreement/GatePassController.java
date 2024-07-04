package com.example.Software.project.Controller.ServiceAgreement;


import com.example.Software.project.Entity.ServiceAgreement.GatePass;
import com.example.Software.project.Repo.ServiceAgreement.GatePassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth/gatePass")
public class GatePassController {
    private final GatePassRepo gatePassRepo;

    public GatePassController(GatePassRepo gatePassRepo) {
        this.gatePassRepo = gatePassRepo;
    }


    @PostMapping("/addGatePass")
    public ResponseEntity<String> addGatePass (@RequestBody GatePass gatePass){
        try{
            gatePassRepo.save(gatePass);
            return ResponseEntity.status(HttpStatus.CREATED).body("Gate Pass Added Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "+ e);
        }
    }

    @GetMapping("/fetchGatePass")
    public ResponseEntity<List<GatePass>> fetchGatePass() {
        List<GatePass> gatePasses = gatePassRepo.findAll();
        return ResponseEntity.ok(gatePasses);
    }

    @GetMapping("/getGatePass")
    public ResponseEntity<?> getGatePass(@RequestParam String id){
        try {
            Optional<GatePass> optionalGatePass = gatePassRepo.findById(id);
            if (optionalGatePass.isPresent()){
                return ResponseEntity.ok().body(optionalGatePass);

            }else {
                return ResponseEntity.badRequest().body("Gate pass not found");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
