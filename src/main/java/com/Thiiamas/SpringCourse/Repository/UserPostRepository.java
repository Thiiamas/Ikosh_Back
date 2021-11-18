package com.Thiiamas.SpringCourse.Repository;

import com.Thiiamas.SpringCourse.Models.UserPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPostRepository extends MongoRepository<UserPost, String> {

}
