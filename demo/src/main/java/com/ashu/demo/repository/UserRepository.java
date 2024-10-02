package com.ashu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username); // Method to find user by username
    
}


//Note: Extends JpaRepository: This allows for CRUD operations on the User entity without needing to implement these methods manually.

//   Custom Method: findByUsername(String username): A method to find a User by their username, allowing for easy retrieval of user data.