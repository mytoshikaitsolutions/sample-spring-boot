package com.alpha.exception;

import com.alpha.constants.AlphaApiMessage;

public class AlphaApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private AlphaApiMessage alphaApiMessage;

	public AlphaApiException() {
		super();
	}

	public AlphaApiException(AlphaApiMessage alphaApiMessage) {
		super();
		this.alphaApiMessage = alphaApiMessage;
	}

	public AlphaApiMessage getAlphaApiMessage() {
		return alphaApiMessage;
	}

}
