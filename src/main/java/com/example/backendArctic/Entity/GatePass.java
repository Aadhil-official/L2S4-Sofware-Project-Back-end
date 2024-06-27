package com.example.backendArctic.Entity;

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
    private String groupName;
    @NotBlank
    private String customerName;

    //private Set<GpMembers> gpMembers = new HashSet<>();

    @NotBlank
    private List<@NotBlank String> gpMembers;


}
