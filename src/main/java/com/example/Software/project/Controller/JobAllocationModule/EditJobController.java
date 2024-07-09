//package com.example.Software.project.Controller.JobAllocationModule;
//import com.example.Software.project.Entity.JobAllocationModule.EditJobEntity;
//import com.example.Software.project.Repo.JobAllocationModule.EditJobRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.web.bind.annotation.*;
//
//
//
//import java.util.List;
//
//import java.util.Optional;
//
//@CrossOrigin("*")
//
//
//@RestController
//@RequestMapping("/api/auth")
//public class EditJobController {
//    @Autowired
//    private EditJobRepo editJob;
//
//    // Get all jobs
//    @GetMapping
//    public List<EditJobEntity> getAllJobs() {
//        return editJob.findAll();
//    }
//
//    // Get job by ID
//    // Get job by ID
//    @GetMapping("/{id}")
//    public EditJobEntity getJobById(@PathVariable String id) {
//        Optional<EditJobEntity> optionalJob = editJob.findById(id);
//        return optionalJob.orElse(null); // Return the Entity if present, otherwise null
//    }
//
//
//    // Create a new job
//    @PostMapping
//    public EditJobEntity createJob(@RequestBody EditJobEntity job) {
//        return editJob.save(job);
//    }
//
//    //Update an existing job
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateJob(@PathVariable String id, @RequestBody EditJobEntity job) {
//        job.setId(id); // Ensure ID is set for update
//        editJob.save(job);
//
//        Optional<EditJobEntity> existingEntity=editJob.findById(id);
//        if (!existingEntity.isEmpty()) {
//            EditJobEntity entity = existingEntity.get();
//
//            entity.setId("1");
//            editJob.save(entity);
//            return ResponseEntity.ok(entity);  // Returning the updated entity with a 200 OK status
//        } else {
//            return ResponseEntity.notFound().build();  // Returning a 404 Not Found status
//        }
//
//    }
//
//
//    // Delete a job
//    @DeleteMapping("/{id}")
//    public void deleteJob(@PathVariable String id) {
//        editJob.deleteById(id);
//    }
//}
