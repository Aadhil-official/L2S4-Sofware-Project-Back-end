package com.example.Software.project.Repo.Item;

import com.example.Software.project.Entity.Item.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ItemRepo extends MongoRepository<Item, String> {

    Boolean existsByOutdoorMod(String outdoorMod);

    Boolean existsByIndoorMod(String indoorMod);

}
