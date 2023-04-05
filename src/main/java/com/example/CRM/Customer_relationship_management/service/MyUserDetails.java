package com.example.CRM.Customer_relationship_management.service;

import java.util.*;
import java.util.stream.Collectors;

import com.example.CRM.Customer_relationship_management.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//an implementation of UserDetails interface to know about the authenticated user information
public class MyUserDetails implements UserDetails {

    private final String userName;
    private final String password;
    private final List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        userName=user.getUsername();
        password=user.getPassword();
        authorities= Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }


    //authorization
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}