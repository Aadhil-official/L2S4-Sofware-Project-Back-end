package com.example.backendArctic.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document

public class SiteVisitDto {
    private String visitId;
    @NotBlank
    private String vehicleNumber;
    @NotBlank
    private String location;
    @NotBlank
    private String groupName;
    @NotBlank
    private String jobType;
    @NotBlank
    private String email;
    @NotBlank
    private String scheduleDate;
    @NotBlank
    private String selectedTime;


}
