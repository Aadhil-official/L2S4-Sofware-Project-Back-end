package com.example.Software.project.Repo.Item;

import com.example.Software.project.Entity.Item.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<Item,String> {
}
