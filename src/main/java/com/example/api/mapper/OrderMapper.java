package com.example.api.mapper;

import com.example.api.model.dto.OrderDTO;
import com.example.api.model.dto.ProductDTO;
import com.example.api.model.dto.response.RqOrderDTO;
import com.example.api.model.entity.ClientEntity;
import com.example.api.model.entity.OrderEntity;
import com.example.api.model.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderDTO OrderEntityToDto(OrderEntity order) {
        return OrderDTO.builder()
                .product( ProductMapper.productEntityToDto(order.getProduct()))
                .client( ClientMapper.ClientEntityToDto(order.getClient()))
                .dateOrder(order.getDateOrder())
                .amount(order.getAmount())
                .build();
    }

    public static List<OrderDTO> OrderEntityListToOrderDtoList(List<OrderEntity> orders){
        return orders.stream()
                .map(order -> OrderDTO.builder()
                        .product( ProductMapper.productEntityToDto(order.getProduct()))
                        .client( ClientMapper.ClientEntityToDto(order.getClient()))
                        .dateOrder(order.getDateOrder())
                        .amount(order.getAmount())
                        .build()

                )
                .collect(Collectors.toList());
    }
    public static  OrderEntity orderDtoToEntity(RqOrderDTO order, ClientEntity client, ProductEntity product) {
        return OrderEntity.builder()
                .product(product)
                .client( client)
                .dateOrder(order.getDateOrder())
                .amount(order.getAmount())
                .build();
    }
}
