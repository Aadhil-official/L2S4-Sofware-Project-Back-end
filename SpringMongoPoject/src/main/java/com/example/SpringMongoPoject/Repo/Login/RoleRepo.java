package com.example.SpringMongoPoject.Repo.Login;


import com.example.SpringMongoPoject.Entity.Login.LogRole;
import com.example.SpringMongoPoject.Entity.Login.Role;

import java.util.Optional;

public interface RoleRepo {
    Optional<Role> findByName(LogRole name);
}
