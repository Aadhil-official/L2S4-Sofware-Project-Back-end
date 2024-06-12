package com.example.Software.project.Controller.Complain;

import com.example.Software.project.Entity.Complain.Complain;
import com.example.Software.project.Entity.DTO.UserComplainDTO;
import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Repo.Complain.ComplainRepo;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.Software.project.Repo.Login.AppUserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
//import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ComplainCont {
    private final List<SseEmitter> sseEmitters = new CopyOnWriteArrayList<>();
    private final ComplainRepo complainRepo;

    private final AppUserRepo appUserRepo;

    public ComplainCont(ComplainRepo complainRepo, AppUserRepo appUserRepo) {
        this.complainRepo = complainRepo;
        this.appUserRepo = appUserRepo;
    }

    @PostMapping("/complaints")
    public ResponseEntity<String> submitComplaint(@RequestBody Complain complain) {
      try {
            complainRepo.save(complain);
            String message = "New complaint added"; // Assuming description is a field in the Complain class
          System.out.println("this is on save or enter complaint");
          notifyClients(message);
            return ResponseEntity.status(HttpStatus.CREATED).body("Complaint submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit complaint");
        }
    }

    @PostMapping("/findcomplaint")
    public ResponseEntity<?> findAllComplaint() {
        {
            try {
                List<AppUser> appUsers = appUserRepo.findAll();
                List<Complain> complains = complainRepo.findAll();

                List<UserComplainDTO> userComplainDTOS = appUsers.stream()
                        .flatMap(user -> complains.stream()
                                .filter(complain -> complain.getEmail().equals(user.getEmail()))
                                .map(complain -> new UserComplainDTO(user, complain))
                        ).collect(Collectors.toList());

                return ResponseEntity.ok().body(userComplainDTOS);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This is error: " + e.getMessage());
            }
        }
    }

    @GetMapping(value = "/newupdates", produces = MediaType.TEXT_EVENT_STREAM_VALUE)//ALL_VALUE
    public SseEmitter complaintUpdates() throws IOException {
        SseEmitter emitter = new SseEmitter(Long.MIN_VALUE);
        emitter.send(SseEmitter.event().name("error"));
        emitter.onCompletion(() -> sseEmitters.remove(emitter));
        sseEmitters.add(emitter);
        System.out.println("after done");
//        emitter.onCompletion(() -> sseEmitters.remove(emitter));
//        emitter.onTimeout(() -> sseEmitters.remove(emitter));
        return emitter;
    }

//    @DeleteMapping("/deletComplain")
//    public ResponseEntity<String> deletComplain(@RequestParam String id){
//        try {
//            complainRepo.deleteById(id);
//            return ResponseEntity.ok("Successfully deleted");
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Error on finding complain");
//        }
//    }

//    @DeleteMapping("/deletComplains")
//    public ResponseEntity<String> deletComplains(){
//        try {
//            complainRepo.deleteAll();
//            return ResponseEntity.ok("Successfully deleted");
//        } catch (Exception e){
//          return ResponseEntity.badRequest().body("Error when delete all");
//        }
//    }

//    @PostMapping("/notification")
    public void notifyClients(@RequestParam String message) {
//        List<SseEmitter> deadEmitters = new ArrayList<>();
//        String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(new Date());
        for (SseEmitter emitter : sseEmitters) {
            try {
                System.out.println("when notify to all");
                emitter.send(SseEmitter.event().name("latest update").data(message));
//                emitter.send(SseEmitter.event().name("latest update").data("{\"message\": \"" + message + "\", \"timestamp\": \"" + timestamp + "\"}"));
            } catch (IOException e) {
                sseEmitters.remove(emitter);
//                deadEmitters.add(emitter);
            }
        }
//        sseEmitters.removeAll(deadEmitters);
    }
}
