package com.example.SpringMongoPoject.Repo.Login;

import com.example.SpringMongoPoject.Entity.Login.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppUserRepo extends MongoRepository<AppUser,String> {
    Optional<AppUser> findByUsername(String username);
//
//    Boolean existsByUsername(String username);
//
//    Boolean existsByEmail(String email);
}
