package com.alpha.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alpha.entity.ClientEntity;

public interface ClientDao {
	
	public Optional<ClientEntity> getClientById(String clientId);

	public Page<ClientEntity> getClients(Pageable pageable);

	public void deleteClient(ClientEntity client);
}
