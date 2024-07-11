package com.example.Software.project.Controller.JobsController;

import com.example.Software.project.Controller.Auth.MessageResponse;
import com.example.Software.project.Dto.JOBSDTO.JobsDTO;
import com.example.Software.project.Entity.JobsEntity.Job;
import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Repo.JobsRepo.JobsRepo;
import com.example.Software.project.Repo.Login.AppUserRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class JobsCon {

    private final JavaMailSender emailSender;

    private final AppUserRepo appUserRepo;

    final
    JobsRepo jobsRepo;

    public JobsCon(JavaMailSender emailSender, AppUserRepo appUserRepo, JobsRepo jobsRepo) {
        this.emailSender = emailSender;
        this.appUserRepo = appUserRepo;
        this.jobsRepo = jobsRepo;
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<?> getAllJobs() {
        try {
            return ResponseEntity.ok().body(jobsRepo.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/addJob")
    public ResponseEntity<?> addJob(@RequestBody Job job) {
        try {
            List<String> teamMembers = job.getTeamMembers();
            List<AppUser> appUsers = new ArrayList<>();

            for (String username : teamMembers) {
                Optional<AppUser> optionalAppUser = appUserRepo.findByUsername(username);
                if (optionalAppUser.isPresent()) {
                    appUsers.add(optionalAppUser.get());
                } else {
                    return ResponseEntity.badRequest().body("User not found");
                }
            }
            if (!jobsRepo.existsByVehicleNumber(job.getVehicleNumber()) && !jobsRepo.existsByDate(job.getDate())) {
                jobsRepo.save(job);
            } else {
                return ResponseEntity.badRequest().body("Vehicle not available");
            }

            String subject = "New job is allocated";
            String object = "Your new job details are as follows.\n\n\nCustomer name: " + job.getCustomerName() + "\nJob Date: " + job.getDate()
                    + "\nYour team members: " + job.getTeamMembers() + "\nYour vehicle number : " + job.getVehicleNumber() + "\n\n"+"Arctict Pvt(Ltd)";

            for (AppUser appUser : appUsers) {
                sendEmail(appUser.getEmail(), subject, object);
            }

            return ResponseEntity.ok().body("Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e);
        }
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
    public ResponseEntity<?> updateJob(@Valid @RequestBody JobsDTO jobDTO) {
        try {
            Optional<Job> optionalJob = jobsRepo.findById(jobDTO.getId());
            if (optionalJob.isPresent()) {
                Job job = optionalJob.get();
                job.setVehicleNumber(jobDTO.getVehicleNumber());
                job.setStatus(jobDTO.getStatus());
                job.setCustomerName(jobDTO.getCustomerName());
                job.setDate(jobDTO.getDate());
                job.setTeamMembers(jobDTO.getTeamMembers());

                List<AppUser> appUsers = new ArrayList<>();

                for (String username : jobDTO.getTeamMembers()) {
                    Optional<AppUser> optionalAppUser = appUserRepo.findByUsername(username);
                    if (optionalAppUser.isPresent()) {
                        appUsers.add(optionalAppUser.get());
                    } else {
                        return ResponseEntity.badRequest().body("User not found");
                    }
                }
                jobsRepo.save(job);
                String vehicleNumber = "";
                String status = "";
                String customerName = "";
                String date = "";
                List<String> teamMembers = new ArrayList<>();

                if (!Objects.equals(jobDTO.getVehicleNumber(), job.getVehicleNumber())) {
//                        String newVehicleNumber = String.join(", ", userDtoRoleNames);
                    vehicleNumber = "Your vehicle number is changed with: " + jobDTO.getVehicleNumber() + "\n";
                }
                if (!Objects.equals(jobDTO.getStatus(), job.getStatus())) {
                    status = "Your job status is changed with: " + jobDTO.getStatus() + "\n";
                }
                if (!Objects.equals(jobDTO.getCustomerName(), job.getCustomerName())) {
                    customerName = "Job customer is changed with: " + jobDTO.getCustomerName() + "\n";
                }
                if (!Objects.equals(jobDTO.getDate(), job.getDate())) {
                    date = "Your job date is changed with: " + jobDTO.getDate() + "\n";
                }
                if (!Objects.equals(jobDTO.getTeamMembers(), job.getTeamMembers())) {
                    teamMembers = Collections.singletonList("Your team members are changed: " + jobDTO.getTeamMembers() + "\n");
                }
                if (!vehicleNumber.isEmpty() || !status.isEmpty() || !customerName.isEmpty() || !date.isEmpty() || !teamMembers.isEmpty()) {
                    String subject = "Your job details are updated ";
                    String object = vehicleNumber + status + customerName + date + teamMembers +"\n\n"+"Arctict Pvt(Ltd)";
                    for (AppUser appUser : appUsers) {
                        sendEmail(appUser.getEmail(), subject, object);
                    }
                }

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
                Job job = optionalJob.get();

                List<AppUser> appUsers = new ArrayList<>();

                for (String username : job.getTeamMembers()) {
                    Optional<AppUser> optionalAppUser = appUserRepo.findByUsername(username);
                    if (optionalAppUser.isPresent()) {
                        appUsers.add(optionalAppUser.get());
                    } else {
                        // Handle the case where the user is not found
                        System.out.println("User not found for username: " + username);
                    }
                }

                String subject = "Your job removed from job list";
                String object = "\nYour job removed from job list" +"\n\nYour removed job date:"+job.getDate() +"\nYour vehicle number"+job.getVehicleNumber() +"\nYour removed job customer name"+job.getCustomerName() +"\n\n"+"Arctict Pvt(Ltd)";


                for (AppUser appUser : appUsers) {
                    subject="Hi"+appUser.getUsername()+subject;
                    sendEmail(appUser.getEmail(), subject, object);
                }

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
