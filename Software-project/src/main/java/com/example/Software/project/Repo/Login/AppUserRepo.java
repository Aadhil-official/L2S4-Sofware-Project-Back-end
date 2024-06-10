package com.example.Software.project.Repo.Login;

import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Entity.Login.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.Set;

//To directly connect by appuser collection from mongodb to make all crud operations
public interface AppUserRepo extends MongoRepository<AppUser,String> {

    //to find the specific appuser by username from db for that I create the transectional oparation for this(as json file)
    Optional<AppUser> findByUsername(String username);
//the meaning of optional there can be no matching username found
    Optional<AppUser> findByEmail(String email);

    Boolean existsByRoles(Set<Role> roles);
    Boolean existsByUsername(String username); //check and give the out as boolean

    Boolean existsByEmail(String email);
}
