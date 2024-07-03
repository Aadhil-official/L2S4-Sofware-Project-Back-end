package com.example.Software.project.Controller.Auth.Response;

import com.example.Software.project.Entity.UserGroup.UserGroup;

public class SignInResponse {
    private UserInfoResponse userInfo;
    private UserGroup userGroup;

    public SignInResponse(UserInfoResponse userInfo, UserGroup userGroup) {
        this.userInfo = userInfo;
        this.userGroup = userGroup;
    }

    public UserInfoResponse getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoResponse userInfo) {
        this.userInfo = userInfo;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}
