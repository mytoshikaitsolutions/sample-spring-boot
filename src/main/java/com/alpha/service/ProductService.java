package com.alpha.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alpha.dto.ResponseDto;

public interface ProductService {

	public Page<ResponseDto> getProducts(boolean deleted, Pageable pageable);

	public ResponseDto deleteProduct(String productId);

}
