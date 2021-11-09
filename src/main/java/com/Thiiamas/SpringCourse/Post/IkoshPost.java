package com.Thiiamas.SpringCourse.Post;

import java.util.List;

public class IkoshPost {
    public String text;
    public List<String> media;

    public IkoshPost(String text, List<String> media) {
        this.text = text;
        this.media = media;
    }

    @Override
    public String toString() {
        return "IkoshPost{" +
                "text='" + text + '\'' +
                ", media=" + media +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }
}
