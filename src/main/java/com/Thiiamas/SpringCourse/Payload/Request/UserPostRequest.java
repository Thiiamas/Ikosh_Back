package com.Thiiamas.SpringCourse.Payload.Request;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UserPostRequest {
    @NotBlank
    private String username;

    @NotBlank
    private Set<String> fanSites;

    private String postText;

    private String imagePath;

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
}
