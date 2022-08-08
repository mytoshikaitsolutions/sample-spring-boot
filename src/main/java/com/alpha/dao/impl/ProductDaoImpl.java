package com.alpha.dao.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.alpha.dao.ProductDao;
import com.alpha.entity.ProductEntity;
import com.alpha.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductDaoImpl implements ProductDao {

	private ProductRepository productRepository;

	@Override
	public Page<ProductEntity> getProducts(boolean deleted, Pageable pageable) {
		if (deleted) {
			return productRepository.findAll(pageable);
		} else {
			return productRepository.findAllByDeleted(deleted, pageable);
		}
	}

	@Override
	public void deleteProduct(ProductEntity product) {
		productRepository.delete(product);
	}

	@Override
	public Optional<ProductEntity> getProductById(String productId) {
		return productRepository.findById(productId);
	}
}