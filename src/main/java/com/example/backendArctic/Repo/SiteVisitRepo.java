package com.example.backendArctic.Repo;

import com.example.backendArctic.Entity.SiteVisit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SiteVisitRepo extends MongoRepository<SiteVisit, String> {

    List<SiteVisit> findByScheduleDate(String scheduleDate);
}
