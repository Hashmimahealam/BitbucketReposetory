package com.spring.boot.jpa.exceptions.dto;

import java.io.Serializable;

public class BadRequestExceptionDto implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer id;

	public BadRequestExceptionDto() {
	}

	public BadRequestExceptionDto(String message,Integer id) {
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
