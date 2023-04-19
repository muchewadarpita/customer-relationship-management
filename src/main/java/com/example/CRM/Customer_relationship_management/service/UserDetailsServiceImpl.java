package com.example.CRM.Customer_relationship_management.service;

//import com.example.CRM.Customer_relationship_management.customexception.MyCustomException;
import com.example.CRM.Customer_relationship_management.model.User;
import com.example.CRM.Customer_relationship_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        if (user == null ) {
            throw new UsernameNotFoundException("Could not find user");
//            throw new MyCustomException("Could not find user");
        }

        return new MyUserDetails(user);
    }

}