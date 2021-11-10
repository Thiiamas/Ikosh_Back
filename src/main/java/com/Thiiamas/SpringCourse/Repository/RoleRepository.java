package com.Thiiamas.SpringCourse.Repository;

import com.Thiiamas.SpringCourse.Models.ERole;
import com.Thiiamas.SpringCourse.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
