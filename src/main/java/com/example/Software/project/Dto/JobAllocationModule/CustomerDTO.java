package com.example.Software.project.Dto.JobAllocationModule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import com.example.Software.project.Dto.JobAllocationModule.TeamMemberDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "JobList")
public class CustomerDTO {
    @Id
    private String id;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String vehicleNumber;
    private String invoiced;
    private LocalDateTime dateAndTime;
    private String toBeInvoiced;
    private List<TeamMemberDTO> teamMembers;

    // Getters and Setters

}
