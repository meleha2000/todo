package com.apps.training.todos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "sec_user")
@Getter
@Setter
public class SecUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name", length = 300, nullable = false, unique = true)
    private String userName;
    private String password;
    private String roleName;


}
