package com.example.backendArctic.Repo;


import com.example.backendArctic.Entity.CancelDates;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelDateRepository extends MongoRepository<CancelDates,Long> {
    boolean existsByVisitId(String visitId);
}
