package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.AgrementService;
import com.example.SpringMongoPoject.Repo.AgrementServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgrementServiceCont {
    @Autowired
    AgrementServiceRepo agrementServiceRepo;
    @PostMapping("/addAgrService")
    public void addAgrService(@RequestBody AgrementService agrementService)
    {
        agrementServiceRepo.save(agrementService);
    }
}
