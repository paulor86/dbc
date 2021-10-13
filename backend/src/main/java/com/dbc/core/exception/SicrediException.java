package com.dbc.core.exception;

public class SicrediException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SicrediException(String message) {
		super(message);
	}

	public SicrediException(String message, Throwable e) {
		super(message, e);
	}
}
