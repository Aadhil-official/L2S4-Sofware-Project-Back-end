package com.example.Software.project.Controller;

import com.example.Software.project.Entity.AgrementService;
import com.example.Software.project.Repo.AgrementServiceRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agrementservicecont")
public class AgrementServiceCont {
    final
    AgrementServiceRepo agrementServiceRepo;

    public AgrementServiceCont(AgrementServiceRepo agrementServiceRepo) {
        this.agrementServiceRepo = agrementServiceRepo;
    }

    @PostMapping("/addAgrService")
    public void addAgrService(@RequestBody AgrementService agrementService)
    {
        agrementServiceRepo.save(agrementService);
    }
}
