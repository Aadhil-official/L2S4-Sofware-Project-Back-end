package com.example.Software.project.Repo.Jobs;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Software.project.Entity.Jobs.Jobs;


@Repository
public interface JobsRepository extends MongoRepository<Jobs, String> {
        long countByDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);  //create custom method to group by month

}
