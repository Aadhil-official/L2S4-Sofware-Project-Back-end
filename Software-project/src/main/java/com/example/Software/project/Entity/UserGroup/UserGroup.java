package com.example.Software.project.Entity.UserGroup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class UserGroup {
    @Id
    private String id;

    @NotBlank
    private String groupName;

    @NotBlank
    private String groupDescription;

    @NotEmpty
    private List<String> relevantPrivileges;

    @NotBlank
    private String allocatedJobs;
}
