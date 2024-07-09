package com.example.Software.project.Controller.JobAllocationModule;

import com.example.Software.project.Service.EmailService;
import com.example.Software.project.Service.JobAllocationModule.EmailServicejob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendSimpleEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }

    static class EmailRequest {
        private String to;
        private String subject="A new job was allocated";
        private String text="Please visit the site for more details.";

        // Getters and setters
        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }



    @GetMapping("/check")
    public String checkEmailService() {
        boolean isConfigured = emailService.isMailServerConfigured();
        if (isConfigured) {
            return "Mail server is configured correctly!";
        } else {
            return "Mail server configuration is incorrect!";
        }
    }
}
