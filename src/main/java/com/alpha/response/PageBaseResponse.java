package com.alpha.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageBaseResponse<T, ID> extends ListBaseResponse<T, ID>{

    long totalElements;
	int totalPages;
	int size;
	int number;
}
