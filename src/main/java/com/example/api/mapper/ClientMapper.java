package com.example.api.mapper;

import com.example.api.model.dto.ClientDTO;
import com.example.api.model.dto.OrderDTO;
import com.example.api.model.dto.ProductDTO;
import com.example.api.model.entity.ClientEntity;
import com.example.api.model.entity.OrderEntity;
import com.example.api.model.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static ClientDTO ClientEntityToDto(ClientEntity client) {
        return ClientDTO.builder()
                .name(client.getName())
                .email(client.getEmail())
                .cellPhone(client.getCellPhone())
                .build();
    }

    public static List<ClientDTO> clientEntityListTotoList(List<ClientEntity> clients){
        return clients.stream()
                .map(client-> ClientDTO.builder()
                        .name(client.getName())
                        .email(client.getEmail())
                        .cellPhone(client.getCellPhone())
                        .build()
                 )
                .collect(Collectors.toList());
    }
    public static  ClientEntity clientDtoToEntity(ClientDTO client) {
         return ClientEntity.builder()
                .name(client.getName())
                .email(client.getEmail())
                .cellPhone(client.getCellPhone())
                .build();
    }
}
