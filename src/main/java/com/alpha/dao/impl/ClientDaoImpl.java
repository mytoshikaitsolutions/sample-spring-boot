package com.alpha.dao.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.alpha.dao.ClientDao;
import com.alpha.entity.ClientEntity;
import com.alpha.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ClientDaoImpl implements ClientDao {

	private ClientRepository clientRepository;

	@Override
	public Page<ClientEntity> getClients(Pageable pageable) {
			return clientRepository.findAll(pageable);
	}

	@Override
	public void deleteClient(ClientEntity client) {
		clientRepository.delete(client);
	}

	@Override
	public Optional<ClientEntity> getClientById(String clientId) {
		return clientRepository.findById(clientId);
	}
}