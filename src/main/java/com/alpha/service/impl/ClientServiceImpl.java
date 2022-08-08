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
import com.alpha.dao.ClientDao;
import com.alpha.dto.ResponseDto;
import com.alpha.entity.ClientEntity;
import com.alpha.exception.AlphaApiException;
import com.alpha.service.ClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {  

	private ModelMapper modelMapper;

	private ClientDao clientDao;

	@Override
	public ResponseDto deleteClient(String clientId) {
		ClientEntity clientEntity = clientDao.getClientById(clientId)
				.orElseThrow(() -> new AlphaApiException(ErrorAlphaApiMessage.CLIENT_NOT_FOUND));
		
		this.clientDao.deleteClient(clientEntity);
		return null;
	}
	
	@Override
	public Page<ResponseDto> getClients(Pageable pageable) {
		Page<ClientEntity> page = clientDao.getClients(pageable);
		List<ClientEntity> clientEntityList = page.getContent();
		List<ResponseDto> data = new ArrayList<>();

		if (Objects.nonNull(clientEntityList)) {
			for (ClientEntity clientEntity : clientEntityList) {
				ResponseDto responseDto = modelMapper.map(clientEntity, ResponseDto.class);
				data.add(responseDto);
			}
		}
		return new PageImpl<ResponseDto>(data, pageable, page.getTotalElements());
	}

}
