package com.alpha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {

	ClientEntity findByName(String clientName);

	Page<ClientEntity> findAll(Pageable pageable);

}
