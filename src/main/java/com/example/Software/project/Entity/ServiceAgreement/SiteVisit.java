package com.example.Software.project.Entity.ServiceAgreement;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Site_Visit")
public class SiteVisit {
    @Id
    private String visitId;
    @NotBlank
    private String vehicleNumber;
    @NotBlank
    private String location;
    @NotBlank
    private String customerName;
    @NotBlank
    private String jobType;
    @NotBlank
    private String email;
    @NotBlank
    private String scheduleDate;
    @NotBlank
    private String selectedTime;
    @NotBlank
    private Number numberOfEmployees;






    public void setSelectedTime(String selectedTime) {
        this.selectedTime=selectedTime;
    }
}
