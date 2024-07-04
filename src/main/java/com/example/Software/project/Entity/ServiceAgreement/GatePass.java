package com.example.Software.project.Entity.ServiceAgreement;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Gate_Pass")
public class GatePass {

    @Id
    private String id;
    @NotBlank
    private String vehicleNumber;
    @NotBlank
    private String customerName;
//    @NotBlank
//    private String numesOfEmployees;

    //private Set<GpMembers> gpMembers = new HashSet<>();

    @NotBlank
    private List<@NotBlank String> gpMembers;


}
