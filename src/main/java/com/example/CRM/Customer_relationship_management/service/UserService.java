package com.example.CRM.Customer_relationship_management.service;

import java.util.List;

import com.example.CRM.Customer_relationship_management.model.User;
import com.example.CRM.Customer_relationship_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long user_id, User user) {
        User existingUser = userRepository.findById(user_id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEnabled(user.isEnabled());
            userRepository.save(existingUser);
        }
        return existingUser;
    }
    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }

    public User getUserByName(String name){

        User user=userRepository.findByUsername(name);

        return user;
    }
}




