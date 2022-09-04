package com.example.Hibernate.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name = "UserName", nullable = false)
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Roles", nullable = false)
    private String roles;
    @Column(name = "IsActive", nullable = false)
    private boolean isActive;
}
