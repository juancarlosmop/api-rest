package com.example.api.service;

import com.example.api.constants.StatusCodeEnum;
import com.example.api.dao.repository.ClientRepository;
import com.example.api.dao.repository.OrderRepository;
import com.example.api.dao.repository.ProductRepository;
import com.example.api.mapper.ClientMapper;
import com.example.api.mapper.OrderMapper;
import com.example.api.model.dto.OrderDTO;
import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.dto.response.RqOrderDTO;
import com.example.api.model.entity.ClientEntity;
import com.example.api.model.entity.OrderEntity;
import com.example.api.model.entity.ProductEntity;
import com.example.api.util.FormatterUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService  implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public GeneralResponseDTO getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        if(orders!=null && !orders.isEmpty()){
            return GeneralResponseDTO
                    .builder()
                    .data(OrderMapper.OrderEntityListToOrderDtoList(orders))
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
                    .message("DATA SUCCESS")
                    .build();
        }
    }

    @Override
    public GeneralResponseDTO getOrderById(Long id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        if(order.isPresent()){
            return GeneralResponseDTO
                    .builder()
                    .data(OrderMapper.OrderEntityToDto(order.get()))
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
                    .message("NOT DATA")
                    .build();
        }
    }

    @Override
    public GeneralResponseDTO saveOrder(RqOrderDTO order) {
        Optional<ClientEntity> foundClient=clientRepository.findById(order.getIdClient());
        Optional<ProductEntity> foundProduct = productRepository.findById(order.getIdProduct());
        if(!foundClient.isPresent()){
            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_004.getDescription())
                    .message("Order was not found")
                    .build();

        }
        if (!foundProduct.isPresent()){
            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_004.getDescription())
                    .message("Product was not found")
                    .build();

        }
        orderRepository.save( OrderMapper.orderDtoToEntity(order,foundClient.get(),foundProduct.get()));
        return GeneralResponseDTO
                .builder()
                .data(Collections.emptyList())
                .dateTime(FormatterUtility.getDatetime())
                .code(StatusCodeEnum.R_001.name())
                .message("Order was created successfully")
                .build();
    }

    @Override
    public GeneralResponseDTO updateOrder(Long id, RqOrderDTO order) {
        Optional<OrderEntity> orderExist = orderRepository.findById(id);
        if (orderExist.isPresent()) {
            OrderEntity orderEntity =orderExist.get();
            Optional<ClientEntity> foundClient=clientRepository.findById(order.getIdClient());
            Optional<ProductEntity> foundProduct = productRepository.findById(order.getIdProduct());
            if(!foundClient.isPresent()){
                return GeneralResponseDTO
                        .builder()
                        .data(Collections.emptyList())
                        .dateTime(FormatterUtility.getDatetime())
                        .code(StatusCodeEnum.R_001.getDescription())
                        .message("Order updated successfully")
                        .build();

            }
            if (!foundProduct.isPresent()){
                return GeneralResponseDTO
                        .builder()
                        .data(Collections.emptyList())
                        .dateTime(FormatterUtility.getDatetime())
                        .code(StatusCodeEnum.R_001.getDescription())
                        .message("Product was created successfully")
                        .build();

            }

            orderEntity.setIdOrder(id);
            orderEntity.setClient(foundClient.get());
            orderEntity.setProduct(foundProduct.get());
            orderRepository.save(orderEntity);

            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_001.getDescription())
                    .message("Order updated successfully")
                    .build();

        }else{
            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_002.getDescription())
                    .message("Order was not updated")
                    .build();
        }
    }

    @Override
    public GeneralResponseDTO deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return GeneralResponseDTO
                .builder()
                .data(Collections.emptyList())
                .dateTime(FormatterUtility.getDatetime())
                .code(StatusCodeEnum.R_001.name())
                .message("Order was deleted successfully")
                .build();
    }
}
