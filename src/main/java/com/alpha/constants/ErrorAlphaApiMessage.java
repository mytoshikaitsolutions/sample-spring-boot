package com.alpha.constants;

import java.util.Collections;
import java.util.List;

public final class ErrorAlphaApiMessage implements AlphaApiMessage {
	
	//Product Api Error
	public static final AlphaApiMessage PRODUCT_NOT_FOUND = new ErrorAlphaApiMessage(710, "Product does not exist in the DB for the given Id");
	
	//Product Api Error
	public static final AlphaApiMessage CLIENT_NOT_FOUND = new ErrorAlphaApiMessage(711, "Client does not exist in the DB for the given Id");
	
	final int resultCode;
	final String message;
	List<String> errors;

	public ErrorAlphaApiMessage(int resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = null;
		this.errors = Collections.singletonList(message);
	}

	public ErrorAlphaApiMessage(int resultCode, String message, List<String> errors) {
		super();
		this.resultCode = resultCode;
		this.message = message;
		this.errors = errors;
	}

	@Override
	public int getResultCode() {
		return resultCode;

	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}
	
    @Override
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
