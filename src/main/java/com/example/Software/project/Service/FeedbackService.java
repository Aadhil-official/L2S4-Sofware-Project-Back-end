package com.example.Software.project.Service;

import com.example.Software.project.Entity.ServiceAgreement.FeedBackForm;
import com.example.Software.project.Repo.ServiceAgreement.FeedBackRepo;
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

