package com.example.SpringMongoPoject.Controller;

import com.example.SpringMongoPoject.Entity.SiteVisit;
import com.example.SpringMongoPoject.Repo.SiteVisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteVisitCont {
    @Autowired
    SiteVisitRepo siteVisitRepo;
    @PostMapping("/addSite")
    public void addSiteVisit(@RequestBody SiteVisit siteVisit)
    {
        siteVisitRepo.save(siteVisit);
    }
}
