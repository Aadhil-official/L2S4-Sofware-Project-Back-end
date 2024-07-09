package com.example.Software.project.Service.JobAllocationModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("uhchewage23@gmail.com");
        message.setTo(to);
        message.setSubject("A new job was allocated");
        message.setText("Please visit the site for more details.");
        emailSender.send(message);
    }

    public boolean isMailServerConfigured() {
        try {
            emailSender.createMimeMessage();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
