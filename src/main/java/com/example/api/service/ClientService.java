package com.example.api.service;

import com.example.api.constants.StatusCodeEnum;
import com.example.api.dao.repository.ClientRepository;
import com.example.api.mapper.ClientMapper;
import com.example.api.mapper.ProductMapper;
import com.example.api.model.dto.ClientDTO;
import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.entity.ClientEntity;
import com.example.api.model.entity.ProductEntity;
import com.example.api.util.FormatterUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public GeneralResponseDTO getAllClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        if(clients!=null && !clients.isEmpty()){
            return GeneralResponseDTO
                    .builder()
                    .data(ClientMapper.clientEntityListTotoList(clients))
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_001.getDescription())
                    .message("DATA SUCCESS")
                    .build();
        }else{
            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_002.getDescription())
                    .message("DATA NOT FOUND")
                    .build();
        }
    }

    @Override
    public GeneralResponseDTO getClientById(Long id) {
        Optional<ClientEntity> client = clientRepository.findById(id);
        if(client.isPresent()){
            return GeneralResponseDTO
                    .builder()
                    .data(ClientMapper.ClientEntityToDto(client.get()))
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_001.getDescription())
                    .message("DATA SUCCESS")
                    .build();
        }else{
            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_004.getDescription())
                    .message("NOT DATA")
                    .build();
        }
    }

    @Override
    public GeneralResponseDTO saveClient(ClientDTO client) {
        clientRepository.save( ClientMapper.clientDtoToEntity(client));
        return GeneralResponseDTO
                .builder()
                .data(Collections.emptyList())
                .dateTime(FormatterUtility.getDatetime())
                .code(StatusCodeEnum.R_001.getDescription())
                .message("Client created successfully")
                .build();
    }

    @Override
    public GeneralResponseDTO updateClient(Long id, ClientDTO client) {
        Optional<ClientEntity> existingProduct = clientRepository.findById(id);
        if (existingProduct.isPresent()) {
            ClientEntity clientEntity =existingProduct.get();
            clientEntity.setIdClient(id);
            clientRepository.save(clientEntity);

            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_001.getDescription())
                    .message("Client updated successfully")
                    .build();

        }else{
            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_002.getDescription())
                    .message("Client was not updated")
                    .build();
        }
    }

    @Override
    public GeneralResponseDTO deleteClient(Long id) {
        clientRepository.deleteById(id);
        return GeneralResponseDTO
                .builder()
                .data(Collections.emptyList())
                .dateTime(FormatterUtility.getDatetime())
                .code(StatusCodeEnum.R_001.getDescription())
                .message("Client was deleted successfully")
                .build();
    }
}
