package com.example.Software.project.Repo.Complain;

import com.example.Software.project.Entity.Complain.ReviewedComplain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewedComplainRepo extends MongoRepository<ReviewedComplain,String> {
}
