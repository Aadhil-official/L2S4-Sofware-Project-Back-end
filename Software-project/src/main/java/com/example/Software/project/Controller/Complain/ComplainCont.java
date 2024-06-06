package com.example.Software.project.Controller.Complain;

import com.example.Software.project.Entity.Complain.Complain;
import com.example.Software.project.Repo.Complain.ComplainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ComplainCont {
    private final List<SseEmitter> sseEmitters = new CopyOnWriteArrayList<>();
    private final ComplainRepo complainRepo;

    public ComplainCont(ComplainRepo complainRepo) {
        this.complainRepo = complainRepo;
    }

    @PostMapping("/complaints")
    public ResponseEntity<String> submitComplaint(@RequestBody Complain complain) {
        try {
            complainRepo.save(complain);
            notifyClients();//Notify all clients of the new complaint
            return ResponseEntity.status(HttpStatus.CREATED).body("Complaint submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit complaint");
        }
    }

    @PostMapping("/findcomplaint")
    public ResponseEntity<?> findAllComplaint() {
        try {
            List<Complain> complains = complainRepo.findAll();
            return ResponseEntity.ok().body(complains);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This is error: " + e.getMessage());
        }
    }


    @GetMapping("/newupdates")
    public SseEmitter complaintUpdates() {
        SseEmitter emitter = new SseEmitter();
        sseEmitters.add(emitter);
        emitter.onCompletion(() -> sseEmitters.remove(emitter));
        emitter.onTimeout(() -> sseEmitters.remove(emitter));
        return emitter;
    }

    private void notifyClients(){
        List<SseEmitter> deadEmitters = new ArrayList<>();
        sseEmitters.forEach(emitter -> {
            try {
                emitter.send(SseEmitter.event().name("complaint").data("New complaint added"));
            } catch (IOException e) {
                deadEmitters.add(emitter);
            }
        });
        sseEmitters.removeAll(deadEmitters);
    }
}
