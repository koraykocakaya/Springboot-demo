package com.kk.springboot.demo.error;

public class DepartmentNotFoundException extends RuntimeException {

	
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public DepartmentNotFoundException() {
		super();
	}

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
