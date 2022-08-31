package com.example.Hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "UserEntity")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String userEmail;
    private String password;
    private String firstName;
    private String lastName;
    private String roles;
    private boolean isActive;
    private boolean isDeleted;

}
