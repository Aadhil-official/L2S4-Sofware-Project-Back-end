package com.example.backendArctic.Controller;

import com.example.backendArctic.Entity.FeedBackForm;
import com.example.backendArctic.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/feedBack")
public class FeedbackController {

    private final FeedbackService feedbackService;

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
}
