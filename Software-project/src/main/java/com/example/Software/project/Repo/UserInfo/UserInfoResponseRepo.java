package com.example.Software.project.Repo.UserInfo;

import com.example.Software.project.Controller.Auth.Response.UserInfoResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoResponseRepo extends MongoRepository<UserInfoResponse,String> {
}
