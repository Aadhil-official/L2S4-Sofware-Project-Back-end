package com.example.Software.project.Repo.UserGroup;

import com.example.Software.project.Entity.UserGroup.UserGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserGroupRepo extends MongoRepository<UserGroup,String> {
    Optional<UserGroup> findByGroupName(String groupName);
    Boolean existsByGroupName(String groupName);
}
