package com.hithaui.Exception;

public class DuplicateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateException(String messager) {
		super(messager);
	}
}
