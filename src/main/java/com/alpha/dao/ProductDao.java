package com.alpha.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alpha.entity.ProductEntity;

public interface ProductDao {
	
	public Optional<ProductEntity> getProductById(String productId);

	public Page<ProductEntity> getProducts(boolean deleted, Pageable pageable);

	public void deleteProduct(ProductEntity product);
}
