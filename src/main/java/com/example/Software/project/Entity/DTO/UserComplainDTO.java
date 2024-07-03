package com.example.Software.project.Entity.DTO;

import com.example.Software.project.Entity.Complain.Complain;
import com.example.Software.project.Entity.Login.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserComplainDTO {
    private AppUser appUser;
    private Complain complain;
}
