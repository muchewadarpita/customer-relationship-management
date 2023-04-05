package com.example.CRM.Customer_relationship_management.model;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean enabled;

    private String roles;
    public Long getId() {
        return id;
    }

    // remaining getters and setters are not shown for brevity
}