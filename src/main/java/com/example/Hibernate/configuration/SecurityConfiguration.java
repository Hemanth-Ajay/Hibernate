package com.example.Hibernate.configuration;

import com.example.Hibernate.provider.MyCustomUserAuthenticationProvider;
import com.example.Hibernate.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MyCustomUserAuthenticationProvider customUserAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("Hemanth").password("{noop}ajay").roles("Admin");
        //Default Authentication implementation
       // auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
        //Custom Authentication provider own Implementation
        auth.authenticationProvider(customUserAuthenticationProvider);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/student/getById/**").authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin();
    }

//    @Bean
//    private BCryptPasswordEncoder getBcrypt(){
//        return new BCryptPasswordEncoder();
//    }
}
