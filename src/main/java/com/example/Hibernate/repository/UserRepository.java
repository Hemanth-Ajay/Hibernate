package com.example.Hibernate.repository;

import com.example.Hibernate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    public UserEntity findByUserEmail(String userEmail);

}
