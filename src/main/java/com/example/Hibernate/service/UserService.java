package com.example.Hibernate.service;

import com.example.Hibernate.entity.UserEntity;
import com.example.Hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserEntity studentEntity) {
        UserEntity user = userRepository.save(studentEntity);
        return user;

    }
}
