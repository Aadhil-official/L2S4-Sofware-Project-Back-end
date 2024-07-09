package com.example.Software.project.Service.JobAllocationModule;//package com.example.project_backend.Service;

import com.example.Software.project.Entity.JobAllocationModule.EditJobEntity;
import com.example.Software.project.Repo.JobAllocationModule.EditJobRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class EditJobService {

    private EditJobRepo buttonRepository;

    public List<EditJobEntity> getAllButtons() {
        return buttonRepository.findAll();
    }


}