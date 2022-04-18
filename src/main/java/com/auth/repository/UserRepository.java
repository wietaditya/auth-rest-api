package com.auth.repository;

import com.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u.password FROM User u WHERE u.id = ?1")
    String getPasswordById(Long id);

    @Query("SELECT u.password FROM User u WHERE u.username = ?1")
    String getPasswordByUsername(String username);
}
