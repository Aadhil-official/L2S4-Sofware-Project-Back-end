package com.example.Software.project.Service.JobAllocationModule;//package com.example.project_backend.Service;






import com.example.project_backend.Entity.EditJobEntity;
import com.example.project_backend.Repository.EditJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;
// import example.job.EditJob;
// import job.example.job.EditJob;



import java.util.List;

@Service
public class EditJobService {

    @Autowired
    private EditJobRepo buttonRepository;

    public List<EditJobEntity> getAllButtons() {
        return buttonRepository.findAll();
    }


}