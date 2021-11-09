package com.Thiiamas.SpringCourse.Post;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Post {
    @Id
    public String id;

    public String user;
    public Date creationDate;
    public String text;
    public String picturePath;
    public boolean hasBeenPosted = false;

    public Post(){}
    public Post(String user, String text) {
        this.user = user;
        this.text = text;
    }
    public Post(String user, Date creationDate, String text, String picturePath) {
        this.user = user;
        this.creationDate = creationDate;
        this.text = text;
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", creationDate=" + creationDate +
                ", text='" + text + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", hasBeenPosted=" + hasBeenPosted +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
