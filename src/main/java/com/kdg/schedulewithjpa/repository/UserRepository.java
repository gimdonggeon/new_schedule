package com.kdg.schedulewithjpa.repository;

import com.kdg.schedulewithjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
