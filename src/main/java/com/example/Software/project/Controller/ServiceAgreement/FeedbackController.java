package com.example.Software.project.Controller.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.AgreementService;
import com.example.Software.project.Entity.ServiceAgreement.FeedBackForm;
import com.example.Software.project.Repo.ServiceAgreement.FeedBackRepo;
import com.example.Software.project.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth/feedBack")
public class FeedbackController {

    private final FeedbackService feedbackService;

    private FeedBackRepo feedBackRepo;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/saveFeedback")
    public ResponseEntity<FeedBackForm> saveFeedback(@RequestBody FeedBackForm feedbackForm) {
        try {
            FeedBackForm savedFeedback = feedbackService.saveFeedback(feedbackForm);
            return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping ("/fetchFeedbacks")
    public ResponseEntity<?> fetchFeedbacks(){

        try {

            return ResponseEntity.ok().body(feedBackRepo.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no Feedbacks");
        }

    }
//    @GetMapping("fetchFeedbacks")
//    public List<FeedBackForm> fetchFeedbacks(){
//        return  feedBackRepo.findAll();
//    }



}
