package com.example.Software.project.Repo.Complain;

import com.example.Software.project.Entity.Complain.Complain;
import org.springframework.data.mongodb.repository.MongoRepository;

//To directly connect by complaint collection from mongodb to make all crud operations
public interface ComplainRepo extends MongoRepository<Complain,String> {
}
