package com.apps.training.todos.entity;

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

    private String userName;
    private String password;
    private String roleName;


}
