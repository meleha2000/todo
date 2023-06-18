package com.apps.training.todos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "sec_user")
@Getter
@Setter
public class SecUser {
    @Id
    private int id;
    @Column(name = "user_name", length = 300, nullable = false, unique = true)
    private String userName;
    private String password;
    private String roleName;


}
