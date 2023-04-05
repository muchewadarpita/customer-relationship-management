package com.example.CRM.Customer_relationship_management.repository;

import com.example.CRM.Customer_relationship_management.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
}