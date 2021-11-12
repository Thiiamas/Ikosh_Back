package com.Thiiamas.SpringCourse.Repository;

import com.Thiiamas.SpringCourse.Models.ERole;
import com.Thiiamas.SpringCourse.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
