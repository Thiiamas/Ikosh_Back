package com.Thiiamas.SpringCourse.User;

import org.springframework.data.annotation.Id;

public class Role {
    @Id
    public String id;

    public String role;

    public Role(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
