package com.alpha.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alpha.constants.ErrorAlphaApiMessage;
import com.alpha.dao.ProductDao;
import com.alpha.dto.ResponseDto;
import com.alpha.entity.ProductEntity;
import com.alpha.exception.AlphaApiException;
import com.alpha.service.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {  

	private ModelMapper modelMapper;

	private ProductDao productDao;

	@Override
	public ResponseDto deleteProduct(String productId) {
		ProductEntity productEntity = productDao.getProductById(productId)
				.orElseThrow(() -> new AlphaApiException(ErrorAlphaApiMessage.PRODUCT_NOT_FOUND));
		
		this.productDao.deleteProduct(productEntity);
		return null;
	}
	
	@Override
	public Page<ResponseDto> getProducts(boolean deleted, Pageable pageable) {
		Page<ProductEntity> page = productDao.getProducts(deleted, pageable);
		List<ProductEntity> productEntityList = page.getContent();
		List<ResponseDto> data = new ArrayList<>();

		if (Objects.nonNull(productEntityList)) {
			for (ProductEntity productEntity : productEntityList) {
				ResponseDto responseDto = modelMapper.map(productEntity, ResponseDto.class);
				data.add(responseDto);
			}
		}
		return new PageImpl<ResponseDto>(data, pageable, page.getTotalElements());
	}

}
