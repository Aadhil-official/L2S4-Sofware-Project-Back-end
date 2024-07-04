package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.EndDates;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndDateRepository extends MongoRepository<EndDates, Long> {
    boolean existsByVisitId(String visitId);
    // You can define custom queries or methods here if needed
}
