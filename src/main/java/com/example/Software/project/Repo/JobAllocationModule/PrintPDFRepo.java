package com.example.Software.project.Repo.JobAllocationModule;

import com.example.Software.project.Entity.JobAllocationModule.PrintPDFEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintPDFRepo extends MongoRepository<PrintPDFEntity, String> {
}
