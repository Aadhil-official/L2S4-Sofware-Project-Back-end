package com.example.Software.project.Repo.Unit;

import com.example.Software.project.Entity.Unit.Unit;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UnitRepo extends MongoRepository<Unit,String> {
//    @NotNull Optional<Unit> findById(@NotNull String id);
}
