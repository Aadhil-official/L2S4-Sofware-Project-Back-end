package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.ClickDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickDateRepository extends MongoRepository<ClickDate, String> {

    boolean existsByVisitId(String visitId);
    // You can define custom queries or methods here if needed
}
