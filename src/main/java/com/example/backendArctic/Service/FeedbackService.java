package com.example.backendArctic.Service;

import com.example.backendArctic.Entity.FeedBackForm;
import com.example.backendArctic.Repo.FeedBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedBackRepo feedbackRepo;

    @Autowired
    public FeedbackService(FeedBackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    public FeedBackForm saveFeedback(FeedBackForm feedbackForm) {
        return feedbackRepo.save(feedbackForm);
    }
}

