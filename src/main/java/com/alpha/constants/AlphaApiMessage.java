package com.alpha.constants;

import java.util.List;

public interface AlphaApiMessage {

	public int getResultCode();

	public String getMessage();

	public List<String> getErrors();

    void setErrors(List<String> errors);
	
}
