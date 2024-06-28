package com.example.api.model.dto;

import com.example.api.model.entity.OrderEntity;
import com.example.api.model.entity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private int  amount;
    @JsonProperty("date_order")
    private Date dateOrder;
    private ClientDTO client;
    private ProductDTO product;
}
