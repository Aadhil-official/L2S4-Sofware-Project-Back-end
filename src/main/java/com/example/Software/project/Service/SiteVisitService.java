package com.example.Software.project.Service;

import com.example.Software.project.Entity.ServiceAgreement.CancelDates;
import com.example.Software.project.Entity.ServiceAgreement.ClickDate;
import com.example.Software.project.Entity.ServiceAgreement.EndDates;
import com.example.Software.project.Entity.ServiceAgreement.SiteVisit;
import com.example.Software.project.Repo.ServiceAgreement.CancelDateRepository;
import com.example.Software.project.Repo.ServiceAgreement.ClickDateRepository;
import com.example.Software.project.Repo.ServiceAgreement.EndDateRepository;
import com.example.Software.project.Repo.ServiceAgreement.SiteVisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SiteVisitService {

    private final ClickDateRepository clickDateRepository;
    private final EndDateRepository endDateRepository;
    private final SiteVisitRepo siteVisitRepo;
    private final CancelDateRepository cancelDateRepository;


    @Autowired
    public SiteVisitService(ClickDateRepository clickDateRepository, EndDateRepository endDateRepository, SiteVisitRepo siteVisitRepo, CancelDateRepository cancelDateRepository) {
        this.clickDateRepository = clickDateRepository;
        this.endDateRepository = endDateRepository;
        this.siteVisitRepo = siteVisitRepo;
        this.cancelDateRepository = cancelDateRepository;




    }

////    public GatePassDto getGatePassDetails (String id){
////        SiteVisit siteVisit =siteVisitRepo.findById(id)
////                .orElseThrow(() -> new ConfigDataResourceNotFoundException("SiteVisit","id",id));
////        AgreementService agreementService = agreementServiceRepo.findById(siteVisit.getId))
////        .orE
//    }
    public void saveClickDate(String visitId) {
        Optional<SiteVisit> siteVisitOptional = siteVisitRepo.findById(visitId);
        if (siteVisitOptional.isPresent()) {
            if (clickDateRepository.existsByVisitId(visitId)) {
                throw new IllegalArgumentException("ClickDate for visitId " + visitId + " already exists");
            }
            SiteVisit siteVisit = siteVisitOptional.get();
            ClickDate clickDate = new ClickDate(new Date(), visitId, siteVisit.getLocation());
            clickDateRepository.save(clickDate);
        } else {
            throw new IllegalArgumentException("SiteVisit with ID " + visitId + " not found");
        }
    }

    public void saveEndDate(String visitId) {
        Optional<SiteVisit> siteVisitOptional = siteVisitRepo.findById(visitId);
        if (siteVisitOptional.isPresent()) {
            if (endDateRepository.existsByVisitId(visitId)) {
                throw new IllegalArgumentException("EndDate for visitId " + visitId + " already exists");
            }
            SiteVisit siteVisit = siteVisitOptional.get();
            EndDates endDate = new EndDates(new Date(), visitId, siteVisit.getLocation());
            endDateRepository.save(endDate);
        } else {
            throw new IllegalArgumentException("SiteVisit with ID " + visitId + " not found");
        }
    }

    public void saveCancelDate(String visitId) {
        Optional<SiteVisit> siteVisitOptional = siteVisitRepo.findById(visitId);
        if (siteVisitOptional.isPresent()) {
            if (cancelDateRepository.existsByVisitId(visitId)) {
                throw new IllegalArgumentException("CancelDate for visitId " + visitId + " already exists");
            }
            SiteVisit siteVisit = siteVisitOptional.get();
            CancelDates cancelDate = new CancelDates(new Date(), visitId, siteVisit.getLocation());
            cancelDateRepository.save(cancelDate);
        } else {
            throw new IllegalArgumentException("SiteVisit with ID " + visitId + " not found");
        }
    }



    public void startSiteVisit(String id) {
        saveClickDate(id);
    }

    public void endSiteVisit(String id) {
        saveEndDate(id);
    }

    public void cancelSiteVisit(String id) {
        saveCancelDate(id);
    }

    public boolean isVisitStarted(String visitId) {
        return clickDateRepository.existsByVisitId(visitId);
    }

    public boolean isVisitEnded(String visitId) {
        return endDateRepository.existsByVisitId(visitId);
    }

    public boolean isVisitCanceled(String visitId) {
        return cancelDateRepository.existsByVisitId(visitId);
    }

    public List<SiteVisit> getAllSiteVisits() {
        return siteVisitRepo.findAll();
    }


}
