package com.example.Software.project.Repo;

import com.example.Software.project.Entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<Item,Integer> {
}
