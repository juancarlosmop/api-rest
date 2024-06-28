package com.example.api.model.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import  java.util.Date;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_order")
    private Long idOrder;
    private int  amount;
    private Date dateOrder;
    @ManyToOne
    @JoinColumn(name = "id_client",nullable = false)
    private ClientEntity client;
    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private  ProductEntity product;
}
