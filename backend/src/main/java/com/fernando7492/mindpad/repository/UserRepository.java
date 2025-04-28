package com.fernando7492.mindpad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando7492.mindpad.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNameContainingIgnoreCase(String name);

    Boolean existById(Long Id);
}
