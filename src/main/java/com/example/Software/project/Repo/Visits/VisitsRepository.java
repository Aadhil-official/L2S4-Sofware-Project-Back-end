package com.example.Software.project.Repo.Visits;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Software.project.Entity.Visits.Visits;

import java.time.LocalDate;
// import java.time.Month;

@Repository
public interface VisitsRepository extends MongoRepository<Visits, String> {
    long countByDateBetween(LocalDate startOfMonth, LocalDate endOfMonth); //create custom method to group by month
}
