package com.example.Software.project.Service;

import com.example.Software.project.Entity.ServiceAgreement.SiteVisit;
import com.example.Software.project.Repo.ServiceAgreement.SiteVisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    private final SiteVisitRepo siteVisitRepo;

    public EmailService(JavaMailSender mailSender, SiteVisitRepo siteVisitRepo) {
        this.mailSender = mailSender;
        this.siteVisitRepo = siteVisitRepo;
    }

    // Method to send a simple email
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    // Scheduled task to run every day at 12 AM
    @Scheduled(cron = "0 45 08 * * ?")
    public void sendSiteVisitReminders() {
        LocalDate today = LocalDate.now();
        List<SiteVisit> visits = siteVisitRepo.findByScheduleDate(today.toString());
        for (SiteVisit visit : visits) {
            sendEmail(
                    visit.getEmail(),
                    "Arctic Pvt.Ltd Site Visit Reminder",
                    "Dear "+visit.getCustomerName()+","+ "\n"+"\n"+
                            "I wish to pay your kind attention above mentioned topic."+"\n\n"+
                            "This is a reminder for your site visit scheduled today at " + visit.getSelectedTime()
                            + "Our team will reach out to you prior to arrival at the location. We greatly appreciate your cooperation and look forward to meeting you." +
                            "\n\n" +
                            "Thank you for your attention." +
                            "\n\n" +
                            "Best Regards,"+"\n"+
                            "Arctic Pvt(Ltd)."
            );
        }
    }

    public void sendSimpleEmail(String to, String subject, String text) {
    }

    public boolean isMailServerConfigured() {

        return false;
    }
}
