package com.Thiiamas.SpringCourse.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Document(collection = "UserPost")
public class UserPost {

    @Id
    private String id;

    @NotBlank
    private String username;

    @NotBlank
    private Set<String> fanSites;

    private String postText;

    private String imagePath;

    private Date date;

    private Boolean isPosted;

    public UserPost(String username, Set<String> fanSites, String postText, String imagePath) {
        this.username = username;
        this.fanSites = fanSites;
        this.postText = postText;
        this.imagePath = imagePath;
    }

    public Boolean getPosted() {
        return isPosted;
    }

    public void setPosted(Boolean posted) {
        isPosted = posted;
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

    public Set<String> getFanSites() {
        return fanSites;
    }

    public void setFanSites(Set<String> fanSites) {
        this.fanSites = fanSites;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
