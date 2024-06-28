package com.example.api.service;

import com.example.api.model.dto.ClientDTO;
import com.example.api.model.dto.OrderDTO;
import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.dto.response.RqOrderDTO;

public interface IOrderService {
    public GeneralResponseDTO getAllOrders();
    public GeneralResponseDTO getOrderById(Long id);
    public GeneralResponseDTO saveOrder(RqOrderDTO order);
    public GeneralResponseDTO updateOrder(Long id, RqOrderDTO order);
    public GeneralResponseDTO deleteOrder(Long id);
}
