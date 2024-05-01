package com.example.Software.project.Controller;

import com.example.Software.project.Entity.Unit;
import com.example.Software.project.Repo.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unitcont")
public class UnitCont {
    @Autowired
    UnitRepo unitRepo;
    @PostMapping("/addUnit")
    public void addUnit(@RequestBody Unit unit)
    {
        unitRepo.save(unit);
    }
}
