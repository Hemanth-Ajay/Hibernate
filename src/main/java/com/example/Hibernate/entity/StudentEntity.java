package com.example.Hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@Table(name = "student")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;
    @Column(unique = true, length = 60, nullable = false)
    @NotBlank(message = "Email id cannot be blank")
    @NotEmpty(message = "Email id cannot be empty")
    private String emailId;
    @NotBlank(message = "firstName id cannot be blank")
    private String firstName;
    @NotBlank(message = "lastName id cannot be blank")
    private String lastName;
    private Date birthday;
    private boolean isActive;
    private boolean isDeleted;


}
