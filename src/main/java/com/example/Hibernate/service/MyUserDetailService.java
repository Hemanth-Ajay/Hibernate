package com.example.Hibernate.service;

import com.example.Hibernate.entity.UserEntity;
import com.example.Hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading the data from the DB to Validated the username
        UserEntity user = userRepository.findByUsername(username);
        if (user ==null){
            throw  new UsernameNotFoundException("The User Name "+username);
        }
        ArrayList<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRoles()));

        return new User(user.getUsername(),user.getPassword(),roles);
    }
}
