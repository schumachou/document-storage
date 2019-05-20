package com.demo.documentstorage.exception;

public class MyFileNotFoundException extends RuntimeException {

	public MyFileNotFoundException() {
		
	}

	public MyFileNotFoundException(String message) {
		super(message);
		
	}

	public MyFileNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public MyFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MyFileNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
