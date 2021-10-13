package com.dbc.core.exception;

public class SicrediRegisterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SicrediRegisterNotFoundException(String className, Integer id) {
		super(String.format("O registro de %s com ID %s não encontrado", className, id));
	}
}
