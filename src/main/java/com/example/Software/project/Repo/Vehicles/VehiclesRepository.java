package com.example.Software.project.Repo.Vehicles;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Software.project.Entity.Vehicles.Vehicles;


@Repository
public interface VehiclesRepository extends MongoRepository<Vehicles, String> {}

