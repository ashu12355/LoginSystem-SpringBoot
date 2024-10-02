package com.ashu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    
}
