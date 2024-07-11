package com.example.Software.project.Entity.JobAllocationModule;

import com.example.Software.project.Dto.JobAllocationModule.TeamMemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "JobList")
public class JobListEntity {

    @Id
    private String id;

    private String customerName;

    @CreatedDate
    private LocalDate date;

    private String vehicleNumber;
    private String status;
    private List<TeamMemberDTO> teamMembers;
}
