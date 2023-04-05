package com.example.CRM.Customer_relationship_management.controller;
import com.example.CRM.Customer_relationship_management.model.User;
import com.example.CRM.Customer_relationship_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("specificUser/{user_id}")
    public User getUserById(@PathVariable Long user_id) {
        return userService.getUserById(user_id);
    }

    @PostMapping("/addnewuser")
    public User createUser(@RequestBody User user) {
        String encodededPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodededPassword);
        user.setEnabled(true);
        return userService.createUser(user);
    }



    @PutMapping("updateUser/{user_id}")
    public User updateUser (@PathVariable Long user_id, @RequestBody User user ) {
        return userService.updateUser(user_id, user);
    }

    @DeleteMapping("deleteUser/{user_id}")
    public void deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
    }

}



