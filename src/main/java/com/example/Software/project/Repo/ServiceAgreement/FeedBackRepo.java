package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.FeedBackForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedBackRepo extends MongoRepository<FeedBackForm,String> {
}
