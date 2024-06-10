package com.example.Software.project.Repo.ServiceAgreement;

import com.example.Software.project.Entity.ServiceAgreement.ServiceAgreement;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ServiceAgreementRepo extends MongoRepository<ServiceAgreement,String> {
}
