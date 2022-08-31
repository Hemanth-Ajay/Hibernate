package com.example.Hibernate.entity;

import lombok.Data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Data
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  ="studentId")
	private Long studentId;
	@Column(unique = true,length = 60,nullable = false)
	private String emailId;
	private String firstName;
	private String lastName;
	private Date birthday;
	private boolean isActive;
	private boolean isDeleted;
	

	
}
