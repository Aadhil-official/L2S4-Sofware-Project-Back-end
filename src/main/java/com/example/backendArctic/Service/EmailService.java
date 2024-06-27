package com.example.backendArctic.Service;

import com.example.backendArctic.Entity.SiteVisit;
import com.example.backendArctic.Repo.SiteVisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SiteVisitRepo siteVisitRepo;

    // Method to send a simple email
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    // Scheduled task to run every day at 8 AM
    @Scheduled(cron = "0 2 13 * * ?")
    public void sendSiteVisitReminders() {
        LocalDate today = LocalDate.now();
        List<SiteVisit> visits = siteVisitRepo.findByScheduleDate(today.toString());
        for (SiteVisit visit : visits) {
            sendEmail(
                    visit.getEmail(),
                    "Site Visit Reminder",
                    "Dear user, this is a reminder for your site visit scheduled today at " + visit.getSelectedTime()
                            + ". Please make sure to start your visit by marking  on System."
            );
        }
    }
}
