package com.cognizant.treatments.exception;

/**
 * 
 * custom based exception class for UserNotFoundException
 *
 */

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);

	}

}
