package com.naokang.oa.common.exception;

/**
 * 业务异常类
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 524110582016690602L;

	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
		this.message = message;
	}

	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public BusinessException(Throwable t) {
		super(t);
	}

}
