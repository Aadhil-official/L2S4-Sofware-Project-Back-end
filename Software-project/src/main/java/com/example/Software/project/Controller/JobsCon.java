package com.example.Software.project.Controller;

//import org.springframework.stereotype.Component;

import com.example.Software.project.Controller.Auth.MessageResponse;
import com.example.Software.project.Entity.DTO.ItemDTO;
import com.example.Software.project.Entity.DTO.JobDTO;
import com.example.Software.project.Entity.Item.Item;
import com.example.Software.project.Entity.Jobs.Job;
import com.example.Software.project.Repo.Jobs.JobsRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class JobsCon {

    private final JavaMailSender emailSender;

    final
    JobsRepo jobsRepo;

    public JobsCon(JavaMailSender emailSender, JobsRepo jobsRepo) {
        this.emailSender = emailSender;
        this.jobsRepo = jobsRepo;
    }

    @GetMapping("/findJobs")
    public List<Job> findJobs() {
        return jobsRepo.findAll();
    }

    @PostMapping("/addJobs")
    public String addJobs(@RequestBody Job job) {
        jobsRepo.save(job);
        String subject = "New job allocation";
        String object = "Your new job details are as followed.\n\n\nItem issue:" + job.getItemIssue() + "\nCustomerDetails:" + job.getCustomerDetails()
                + "\nEmployee details:" + job.getEmployeeDetails() + "\nLocation:" + job.getLocation() + "\nItem:" + job.getItem();
        String email = job.getEmail();
        sendEmail(email, subject, object);
        return "Saved Successfully";
    }


    @GetMapping("/getJob")
    public ResponseEntity<?> getJob(@RequestParam String id) {
        try {
            Optional<Job> job = jobsRepo.findById(id);
            return ResponseEntity.ok().body(job);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateJob")
    public ResponseEntity<?> updateJob(@Valid @RequestBody JobDTO jobDTO) {
        try {
            Optional<Job> optionalJob = jobsRepo.findById(jobDTO.getId());
            if (optionalJob.isPresent()) {
                Job job = optionalJob.get();
                job.setItem(jobDTO.getItem());
                job.setItemIssue(jobDTO.getItemIssue());
                job.setLocation(jobDTO.getLocation());
                job.setCustomerDetails(jobDTO.getCustomerDetails());
                job.setEmployeeDetails(jobDTO.getEmployeeDetails());
                job.setEmail(jobDTO.getEmail());
                jobsRepo.save(job);
                return ResponseEntity.ok(new MessageResponse("Job updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job with ID " + jobDTO.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating job: " + e.getMessage());
        }
    }

    @DeleteMapping("/dltJob")
    public ResponseEntity<MessageResponse> dltJob(@RequestParam String id) {
        Optional<Job> optionalJob = jobsRepo.findById(id);
        try {
            if (optionalJob.isPresent()) {
                jobsRepo.delete(optionalJob.get());
                return ResponseEntity.ok(new MessageResponse("Job deleted Successfully"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Job not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error on delete job: " + e.getMessage()));
        }
    }

    @DeleteMapping("/clearAllJobs")
    public ResponseEntity<MessageResponse> clearAllJobs() {
        try {
            jobsRepo.deleteAll();
            return ResponseEntity.ok(new MessageResponse("Successfully delete all jobs"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error on delete all jobs: " + e.getMessage()));
        }
    }

    private void sendEmail(String email, String subject, String object) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(object);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }

}
