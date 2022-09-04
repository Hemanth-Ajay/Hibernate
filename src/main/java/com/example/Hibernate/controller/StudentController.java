package com.example.Hibernate.controller;

import com.example.Hibernate.entity.StudentEntity;
import com.example.Hibernate.entity.UserEntity;
import com.example.Hibernate.service.StudentService;
import com.example.Hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/getById/{id}")
    private StudentEntity getByStudentId(@PathVariable Long id) {
        if (id == 0) {
            throw new IllegalStateException("Id Field should not be empty");
        }
        StudentEntity enStudentEntity = studentService.getByStudentId(id);
        return enStudentEntity;

    }

    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateStudentDetails(@PathVariable Long id, @RequestBody StudentEntity entity) {
        StudentEntity updateStudentDetails = studentService.updateStudentDetails(id, entity);

        return ResponseEntity.ok(updateStudentDetails);

    }

    @PostMapping("/createuser")
    private UserEntity createUser(@RequestBody UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        UserEntity user = userService.saveUser(userEntity);
        return user;
    }

}
