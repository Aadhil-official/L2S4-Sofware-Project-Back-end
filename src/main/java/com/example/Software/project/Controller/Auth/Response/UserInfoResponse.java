package com.example.Software.project.Controller.Auth.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {

    private String id;
    private String username;
    private String email;
    private String address;
    private String usergroup;
    private String tel;
    private List<String> roles;

}
