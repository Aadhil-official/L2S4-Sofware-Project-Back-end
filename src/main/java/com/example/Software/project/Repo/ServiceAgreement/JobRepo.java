package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepo extends MongoRepository<Job,String> {

}
