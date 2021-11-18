package com.Thiiamas.SpringCourse.Payload.Request;

import javax.validation.constraints.NotBlank;

public class AccountDetailsRequest {

    @NotBlank
    private String username;

    private String fanslyLogin;

    private String fanslyPW;

    private String mymLogin;

    private String mymPW;

    private String swameLogin;

    private String swamePW;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFanslyLogin() {
        return fanslyLogin;
    }

    public void setFanslyLogin(String fanslyLogin) {
        this.fanslyLogin = fanslyLogin;
    }

    public String getFanslyPW() {
        return fanslyPW;
    }

    public void setFanslyPW(String fanslyPW) {
        this.fanslyPW = fanslyPW;
    }

    public String getMymLogin() {
        return mymLogin;
    }

    public void setMymLogin(String mymLogin) {
        this.mymLogin = mymLogin;
    }

    public String getMymPW() {
        return mymPW;
    }

    public void setMymPW(String mymPW) {
        this.mymPW = mymPW;
    }

    public String getSwameLogin() {
        return swameLogin;
    }

    public void setSwameLogin(String swameLogin) {
        this.swameLogin = swameLogin;
    }

    public String getSwamePW() {
        return swamePW;
    }

    public void setSwamePW(String swamePW) {
        this.swamePW = swamePW;
    }

    @Override
    public String toString() {
        return "AccountDetailsRequest{" +
                "username='" + username + '\'' +
                ", fanslyLogin='" + fanslyLogin + '\'' +
                ", fanslyPW='" + fanslyPW + '\'' +
                ", mymLogin='" + mymLogin + '\'' +
                ", mymPW='" + mymPW + '\'' +
                ", swameLogin='" + swameLogin + '\'' +
                ", swamePW='" + swamePW + '\'' +
                '}';
    }
}
