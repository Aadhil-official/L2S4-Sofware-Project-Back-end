package com.example.Software.project.Dto.JobAllocationModule;

import com.example.Software.project.Entity.JobAllocationModule.PrintPDFEntity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PrintDTO {
    @NotBlank
    @Id
    private String id;
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
    @Email
    @NotBlank
    private String email;
    private String jobId;
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

    public PrintDTO(PrintPDFEntity printPDFEntity) {
    }

    public String getJobId() {
        return jobId;
    }

    public String getItemIssue() {
        return itemIssue;
    }

    public String getCustomerDetails() {
        return customerDetails;
    }

    public String getEmployeeDetails() {
        return employeeDetails;
    }

    public String getLocation() {
        return location;
    }

    public String getItem() {
        return item;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {

        return customerAddress;
    }

    public String getEmployeeName() {

        return employeeName;
    }

    public String getEmployeePhone() {

        return employeePhone;
    }

    public String getEmployeeDesignation() {

        return employeeDesignation;
    }


    // Getters and setters
}
