package com.example.Software.project.Dto.JobAllocationModule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import com.example.project_backend.DTO.TeamMemberDTO;
import java.util.List;

@Getter
@Setter
public class CustomerDTO {
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
