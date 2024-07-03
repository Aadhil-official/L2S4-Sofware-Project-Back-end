package com.example.backendArctic.Repo;

import com.example.backendArctic.Entity.FeedBackForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedBackRepo extends MongoRepository<FeedBackForm ,String> {
}
