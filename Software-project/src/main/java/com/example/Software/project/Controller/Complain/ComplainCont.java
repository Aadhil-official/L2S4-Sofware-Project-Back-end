package com.example.Software.project.Controller.Complain;

import com.example.Software.project.Entity.Complain.Complain;
import com.example.Software.project.Repo.Complain.ComplainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ComplainCont {

    final
    AuthenticationManager authenticationManager;
    final
    ComplainRepo complainRepo;

    public ComplainCont(ComplainRepo complainRepo, AuthenticationManager authenticationManager) {
        this.complainRepo = complainRepo;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/complain")
    public void addComplain(@RequestBody Complain complain) {
        complainRepo.save(complain);
    }

}
