package com.example.Software.project.Repo.Complain;

import com.example.Software.project.Entity.Complain.Complain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplainRepo extends MongoRepository<Complain,String> {
}
