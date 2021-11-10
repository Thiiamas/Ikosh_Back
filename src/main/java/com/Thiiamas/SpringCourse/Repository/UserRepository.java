package com.Thiiamas.SpringCourse.Repository;

import com.Thiiamas.SpringCourse.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    Boolean existByUsername(String username);

    Boolean existByEmail(String email);
}
