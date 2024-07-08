package com.example.Software.project.Repo.Agrements;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Software.project.Entity.Agrements.Agreement;

public interface AgreementRepository extends MongoRepository<Agreement, String> {
}
