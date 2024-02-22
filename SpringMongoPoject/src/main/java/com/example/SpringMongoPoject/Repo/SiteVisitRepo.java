package com.example.SpringMongoPoject.Repo;

import com.example.SpringMongoPoject.Entity.SiteVisit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteVisitRepo extends MongoRepository<SiteVisit,Integer> {
}
