package com.example.project_backend.Entity;//package com.example.project_backend.Entity;
//
//import jakarta.validation.constraints.NotBlank;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "buttons")
//public class EditJob {
//    @Id
//    private String id;
////public String getAllButtons(){
////
////}
//@NotBlank
//    private String Customer;
//    @NotBlank
//    private String Date;
//    @NotBlank
//    private String TeamMember;
//    @NotBlank
//    private String VehicleNumber;
//    @NotBlank
//    private String ToBeInvoiced;
//    @NotBlank
//    private String Invoiced;
//
//    public String getCustomer() {
//
//        return Customer;
//    }
//    public String getDate() {
//
//        return Date;
//    }
//    public String getTeamMember() {
//
//        return TeamMember;
//    }
//    public String getVehicleNumber() {
//
//        return VehicleNumber;
//    }
//    public String getToBeInvoiced() {
//
//        return ToBeInvoiced;
//    }
//    public String getInvoiced() {
//
//        return Invoiced;
//    }
//    // Getters and Setters
//}






import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "EditJob(buttons)")
public class EditJobEntity {

    //public String getAllButtons(){
//
//}
    @CreationTimestamp
    private LocalDate date;

    private String Customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;


    private String TeamMember;

    private String VehicleNumber;

    private String ToBeInvoiced;

    private String Invoiced;



    // Getters and Setters
}