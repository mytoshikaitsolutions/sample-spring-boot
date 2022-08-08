package com.alpha.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new base response.
 */

/**
 * Instantiates a new base response.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseResponse<T, ID> extends GenericResponse{
	
	/** The data. */
	T data;
}
