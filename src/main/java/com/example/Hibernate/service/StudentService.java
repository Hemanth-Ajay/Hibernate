package com.example.Hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Hibernate.entity.StudentEntity;
import com.example.Hibernate.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public StudentEntity getByStudentId(Long studentId) {
		StudentEntity entity = null;
		try {
			entity = studentRepository.findById(studentId).get();

		} catch (Exception e) {
			e.getMessage();
		}
		return entity;
	}
}
