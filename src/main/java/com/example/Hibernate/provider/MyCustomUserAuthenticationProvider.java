package com.example.Hibernate.provider;

import com.example.Hibernate.entity.UserEntity;
import com.example.Hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MyCustomUserAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //add your DB logic for user validation instead of custom implementation
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserEntity user = userRepository.findByUsername(username);
        if(user != null){
            boolean passwordMatches = passwordEncoder.matches(password, user.getPassword());
            if(passwordMatches){
                ArrayList<GrantedAuthority> roles =new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(user.getRoles()));

                return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),roles);
            }
            else {
                throw new BadCredentialsException("please enter username/password is valid or not ");
            }
        }
        else {
            throw new UsernameNotFoundException("User you entered is not there in our DataBase");
        }


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals( UsernamePasswordAuthenticationToken.class);
    }
}
