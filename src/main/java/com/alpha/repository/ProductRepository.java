package com.alpha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

	ProductEntity findByName(String productName);

	Page<ProductEntity> findAllByDeleted(boolean deleted, Pageable pageable);

}
