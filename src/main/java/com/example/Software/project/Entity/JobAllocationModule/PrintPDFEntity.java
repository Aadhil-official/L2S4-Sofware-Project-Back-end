package com.example.Software.project.Entity.JobAllocationModule;

import com.example.Software.project.Dto.JobAllocationModule.PrintDTO;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "PrintPDF")
public class PrintPDFEntity {
    @Id
    @NotBlank
    private String jobId;
    @NotBlank
    private String itemIssue;
    @NotBlank
    private String customerDetails;
    @NotBlank
    private String employeeDetails;
    @NotBlank
    private String location;
    @NotBlank
    private String item;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String customerName;
    @NotBlank
    private String customerPhone;
    @NotBlank
    private String customerAddress;
    @NotBlank
    private String employeeName;
    @NotBlank
    private String employeePhone;
    @NotBlank
    private String employeeDesignation;

    // Constructors, getters, and setters

    public PrintPDFEntity(PrintDTO jobPrintDTO) {
        this.jobId = jobPrintDTO.getJobId();
        this.itemIssue = jobPrintDTO.getItemIssue();
        this.customerDetails = jobPrintDTO.getCustomerDetails();
        this.employeeDetails = jobPrintDTO.getEmployeeDetails();
        this.location = jobPrintDTO.getLocation();
        this.item = jobPrintDTO.getItem();
        this.email = jobPrintDTO.getEmail();
        this.customerName = jobPrintDTO.getCustomerName();
        this.customerPhone = jobPrintDTO.getCustomerPhone();
        this.customerAddress = jobPrintDTO.getCustomerAddress();
        this.employeeName = jobPrintDTO.getEmployeeName();
        this.employeePhone = jobPrintDTO.getEmployeePhone();
        this.employeeDesignation = jobPrintDTO.getEmployeeDesignation();
    }

    public PrintPDFEntity() {

    }



}

