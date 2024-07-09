package com.example.Software.project.Controller.JobAllocationModule;

import com.example.Software.project.Entity.JobAllocationModule.JobListEntity;
import com.example.Software.project.Repo.JobAllocationModule.JobListRepository;
import com.example.Software.project.Service.JobAllocationModule.JobListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/displayJob")
public class AdminJobController {

    private final JobListRepository jobRepository;
    private final JobListService jobListService;

    @Autowired
    public AdminJobController(JobListRepository jobRepository, JobListService jobListService) {
        this.jobRepository = jobRepository;
        this.jobListService = jobListService;
    }

    @GetMapping
    public List<JobListEntity> getAllJobs() {

        return jobListService.getAllJobs();

    }

    @PostMapping("/addJob")
    public String addJob(@RequestBody JobListEntity job) {
        JobListEntity entity = new JobListEntity();
        entity.setCustomerName(job.getCustomerName());
        entity.setDate(LocalDate.now());
        entity.setTeamMembers(job.getTeamMembers());
        System.out.println(job.getTeamMembers());
        entity.setStatus(job.getStatus());
        entity.setVehicleNumber(job.getVehicleNumber());

        jobRepository.save(entity);
        return "Saved Successfully";
    }

    @PutMapping("/updatedjob/{id}")
    public ResponseEntity<?> updateJob(@PathVariable String id, @RequestBody JobListEntity job) {
        Optional<JobListEntity> existingEntity = jobRepository.findById(id);
        if (existingEntity.isPresent()) {
            JobListEntity entity = existingEntity.get();

            entity.setCustomerName(job.getCustomerName());
            entity.setDate(job.getDate());
            entity.setTeamMembers(job.getTeamMembers());
            entity.setStatus(job.getStatus());
            entity.setVehicleNumber(job.getVehicleNumber());
            System.out.println(entity.getTeamMembers());
            jobRepository.save(entity);
            return ResponseEntity.ok(entity);  // Returning the updated entity with a 200 OK status
        } else {
            return ResponseEntity.notFound().build();  // Returning a 404 Not Found status
        }
    }

    @DeleteMapping("/removed/{id}")
    public void deleteJob(@PathVariable String id) {
        jobRepository.deleteById(id);
    }
}
