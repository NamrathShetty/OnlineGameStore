package com.gamestore.exception;

public class GameNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameNotFoundException() {
		super();
	}

	public GameNotFoundException(String message) {
		super(message);
		System.out.println(message);
	}

}
