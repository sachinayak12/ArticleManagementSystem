package com.user.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String password;

    public String getUserName()
    {
        return userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
