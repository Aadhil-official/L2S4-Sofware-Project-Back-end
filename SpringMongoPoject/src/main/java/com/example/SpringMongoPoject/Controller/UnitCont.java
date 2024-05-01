package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.Unit;
import com.example.SpringMongoPoject.Repo.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitCont {
    @Autowired
    UnitRepo unitRepo;
    @PostMapping("/addUnit")
    public void addUnit(@RequestBody Unit unit)
    {
        unitRepo.save(unit);
    }
}
