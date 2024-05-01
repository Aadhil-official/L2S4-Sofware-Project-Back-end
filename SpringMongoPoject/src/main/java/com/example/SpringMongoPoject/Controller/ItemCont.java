package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.Item;
import com.example.SpringMongoPoject.Repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemCont {
    @Autowired
    ItemRepo itemRepo;
    @PostMapping("/addItem")
    public void addItem(@RequestBody Item item)
    {
        itemRepo.save(item);
    }
}
