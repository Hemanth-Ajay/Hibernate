package com.example.Hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hibernate.entity.StudentEntity;
import com.example.Hibernate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("getById/{id}")
	private StudentEntity getByStudentId(@PathVariable Long id) {
		if (id == 0) {
			throw new IllegalStateException("Id Field should not be empty");
		}
		StudentEntity enStudentEntity = studentService.getByStudentId(id);
		return enStudentEntity;

	}

}
