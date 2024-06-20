package com.example.Software.project.Entity.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class UserGroupDTO {
    private String id;

    @NotBlank
    private String groupName;

    @NotBlank
    private String groupDescription;

    @NotBlank
    private String relevantPrivileges;

    @NotBlank
    private String allocatedJobs;
}
