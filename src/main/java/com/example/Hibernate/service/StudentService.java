package com.example.Hibernate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Hibernate.entity.StudentEntity;
import com.example.Hibernate.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	private Optional<StudentEntity> findById;

	public StudentEntity getByStudentId(Long studentId) {
		StudentEntity entity = null;
		try {
			entity = studentRepository.findById(studentId).get();

		} catch (Exception e) {
			e.getMessage();
		}
		return entity;
	}

	public StudentEntity updateStudentDetails(Long id, StudentEntity studentEntity) {
		StudentEntity findById = studentRepository.findById(id).get();

		findById.setFirstName(studentEntity.getFirstName());
		findById.setLastName(studentEntity.getLastName());
		findById.setBirthday(studentEntity.getBirthday());
		try {
			studentRepository.save(findById);
		} catch (IllegalStateException e) {
		e.getLocalizedMessage();
		}

		return findById;

	}
}
