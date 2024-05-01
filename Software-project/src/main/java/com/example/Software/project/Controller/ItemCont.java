package com.example.Software.project.Controller;

import com.example.Software.project.Entity.Item;
import com.example.Software.project.Repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itemcont")
public class ItemCont {
    @Autowired
    ItemRepo itemRepo;
    @PostMapping("/addItem")
    public void addItem(@RequestBody Item item)
    {
        itemRepo.save(item);
    }
}
