package com.alpha.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alpha.dto.ResponseDto;

public interface ClientService {

	public Page<ResponseDto> getClients(Pageable pageable);

	public ResponseDto deleteClient(String clientId);

}
