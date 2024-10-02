package com.ashu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.demo.model.User;
import com.ashu.demo.repository.UserRepository;

@Service //@Service: Marks this class as a service in the service layer.
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        User user = userRepository.findByUsername(username); // Fetches user by username
        return user != null && user.getPassword().equals(password); // Validates password
    }
}
