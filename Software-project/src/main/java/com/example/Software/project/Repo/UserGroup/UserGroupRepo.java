package com.example.Software.project.Repo.UserGroup;

import com.example.Software.project.Entity.UserGroup.UserGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserGroupRepo extends MongoRepository<UserGroup,String> {
    Boolean existsByGroupName(String groupName);
}
