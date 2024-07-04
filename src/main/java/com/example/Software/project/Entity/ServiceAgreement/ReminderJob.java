//package com.example.backendArctic.Entity;
//
//import com.example.backendArctic.Repo.SiteVisitRepo;
//import com.example.backendArctic.Service.EmailService;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneId;
//import java.util.List;
//
//public class ReminderJob extends QuartzJobBean {
//    @Autowired
//    private SiteVisitRepo siteVisitRepo;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Override
//    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        LocalDateTime nowDateTimeUTC = LocalDateTime.now(ZoneId.of("UTC"));
//        LocalDateTime nextHourTimeUTC = nowDateTimeUTC.plusHours(1);
//
//        // Ensure correct initialization of LocalDate and LocalTime
//        LocalDate nowDate = nowDateTimeUTC.toLocalDate();
//        Time nowTime = Time.valueOf(nowDateTimeUTC.toLocalTime());
//        Time nextHourTime = Time.valueOf(nextHourTimeUTC.toLocalTime());
//
//        List<SiteVisit> siteVisits = siteVisitRepo.findByScheduleDateAndSelectedTimeBetween(nowDate, nowTime, nextHourTime);
//        for (SiteVisit visit : siteVisits) {
//            emailService.sendReminder(visit);
//        }
//    }
//}
