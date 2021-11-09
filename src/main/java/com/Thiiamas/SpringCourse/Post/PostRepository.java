package com.Thiiamas.SpringCourse.Post;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
        public Post findByUser(String user);
}
