package com.example.Software.project.Repo;

import com.example.Software.project.Entity.SiteVisit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteVisitRepo extends MongoRepository<SiteVisit,Integer> {
}
