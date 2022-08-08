package com.alpha.response;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ListBaseResponse<T, ID> extends GenericResponse{

	@JsonInclude(value = Include.ALWAYS)
	List<T> dataList = Collections.emptyList();
	
}
