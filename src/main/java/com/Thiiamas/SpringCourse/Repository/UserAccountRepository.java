package com.Thiiamas.SpringCourse.Repository;

import com.Thiiamas.SpringCourse.Models.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    Optional<UserAccount> findByUsername(String username);

    Boolean existsByUsername(String username);
}
