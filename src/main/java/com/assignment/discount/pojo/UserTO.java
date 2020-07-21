package com.assignment.discount.pojo;

import java.time.LocalDate;

public class UserTO {
    private String userName;
    private UserType userType;
    private LocalDate dateOfRegistration;

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
