package com.example.Hibernate.service;

import com.example.Hibernate.dto.UserModel;
import com.example.Hibernate.entity.UserEntity;
import com.example.Hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading the data from the DB to Validated the username
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The User Name " + username);
        }


        return new UserModel(user.getUsername(), user.getPassword(), user.getRoles(), user.isActive());
    }
}
