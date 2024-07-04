package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.SiteVisit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SiteVisitRepo extends MongoRepository<SiteVisit, String> {

    List<SiteVisit> findByScheduleDate(String scheduleDate);
}
