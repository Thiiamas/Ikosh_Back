package com.Thiiamas.SpringCourse.Models;

import com.Thiiamas.SpringCourse.Payload.Request.AccountDetailsRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "UserAccount")
public class UserAccount {

    @Id
    private String id;

    private String username;

    private String fanslyLogin;

    private String fanslyPW;

    private String mymLogin;

    private String mymPW;

    private String swameLogin;

    private String swamePW;

    public UserAccount(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserAccount(String username) {
        this.username = username;
    }

    public UserAccount(String id, String username, String fanslyLogin, String fanslyPW, String mymLogin, String mymPW, String swameLogin, String swamePW) {
        this.id = id;
        this.username = username;
        this.fanslyLogin = fanslyLogin;
        this.fanslyPW = fanslyPW;
        this.mymLogin = mymLogin;
        this.mymPW = mymPW;
        this.swameLogin = swameLogin;
        this.swamePW = swamePW;
    }

    public UserAccount(AccountDetailsRequest accountDetailsRequest){
        this.username = accountDetailsRequest.getUsername();

        this.fanslyLogin = accountDetailsRequest.getFanslyLogin();;
        this.fanslyPW = accountDetailsRequest.getFanslyPW();

        this.mymLogin = accountDetailsRequest.getMymLogin();
        this.mymPW = accountDetailsRequest.getMymPW();

        this.swameLogin = accountDetailsRequest.getSwameLogin();
        this.swamePW = accountDetailsRequest.getSwamePW();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return "UserAccount{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fanslyLogin='" + fanslyLogin + '\'' +
                ", fanslyPW='" + fanslyPW + '\'' +
                ", mymLogin='" + mymLogin + '\'' +
                ", mymPW='" + mymPW + '\'' +
                ", swameLogin='" + swameLogin + '\'' +
                ", swamePW='" + swamePW + '\'' +
                '}';
    }
}
