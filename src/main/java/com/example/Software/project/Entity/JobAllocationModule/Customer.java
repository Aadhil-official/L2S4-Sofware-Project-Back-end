
//add new job form එක

package com.example.project_backend.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Document(collection = "AddNewJob")
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String vehicleNumber;
    private String invoiced;
    private LocalDateTime dateAndTime;
    private String toBeInvoiced;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<TeamMemberEntity> teamMembers;

    // Getters and Setters
    // ...
}
