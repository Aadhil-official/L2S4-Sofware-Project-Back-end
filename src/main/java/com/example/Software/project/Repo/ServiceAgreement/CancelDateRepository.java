package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.CancelDates;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelDateRepository extends MongoRepository<CancelDates,String> {
    boolean existsByVisitId(String visitId);
}
