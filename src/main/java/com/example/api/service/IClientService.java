package com.example.api.service;

import com.example.api.model.dto.ClientDTO;
import com.example.api.model.dto.ProductDTO;
import com.example.api.model.dto.response.GeneralResponseDTO;

public interface IClientService {
    public GeneralResponseDTO getAllClients();
    public GeneralResponseDTO getClientById(Long id);
    public GeneralResponseDTO saveClient(ClientDTO client);
    public GeneralResponseDTO updateClient(Long id, ClientDTO client);
    public GeneralResponseDTO deleteClient(Long id);
}
