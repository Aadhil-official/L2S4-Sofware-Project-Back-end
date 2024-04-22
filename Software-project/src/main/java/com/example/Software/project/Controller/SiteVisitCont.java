package com.example.Software.project.Controller;

import com.example.Software.project.Entity.SiteVisit;
import com.example.Software.project.Repo.SiteVisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sitevisitcont")
public class SiteVisitCont {
    @Autowired
    SiteVisitRepo siteVisitRepo;
    @PostMapping("/addSite")
    public void addSiteVisit(@RequestBody SiteVisit siteVisit)
    {
        siteVisitRepo.save(siteVisit);
    }
}
