package com.example.SpringMongoPoject.Repo;

import com.example.SpringMongoPoject.Entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<Item,Integer> {
}
