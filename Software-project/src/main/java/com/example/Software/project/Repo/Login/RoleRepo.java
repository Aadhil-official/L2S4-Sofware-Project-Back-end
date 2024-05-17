package com.example.Software.project.Repo.Login;

import com.example.Software.project.Entity.Login.LogRole;
import com.example.Software.project.Entity.Login.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepo extends MongoRepository<Role,String> {
    Optional<Role> findByName(LogRole name);

    Boolean existsByName(LogRole name);
}
