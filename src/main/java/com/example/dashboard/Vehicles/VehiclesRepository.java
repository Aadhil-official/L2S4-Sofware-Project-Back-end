package com.example.dashboard.Vehicles;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiclesRepository extends MongoRepository<Vehicles, String> {}