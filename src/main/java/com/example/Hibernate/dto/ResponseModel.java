package com.example.Hibernate.dto;

import com.example.Hibernate.entity.StudentEntity;

public class ResponseModel {

	public ResponseModel() {

	}

	public ResponseModel(String message, String statusCode, StudentEntity entity) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.entity = entity;
	}

	private String message;
	private String statusCode;
	private StudentEntity entity;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public StudentEntity getEntity() {
		return entity;
	}

	public void setEntity(StudentEntity entity) {
		this.entity = entity;
	}

}
