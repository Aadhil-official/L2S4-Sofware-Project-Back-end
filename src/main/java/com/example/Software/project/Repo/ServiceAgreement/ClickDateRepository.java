package com.example.backendArctic.Repo;

import com.example.backendArctic.Entity.ClickDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickDateRepository extends MongoRepository<ClickDate, Long> {

    boolean existsByVisitId(String visitId);
    // You can define custom queries or methods here if needed
}
