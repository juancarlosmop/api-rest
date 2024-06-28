package com.example.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_client")
    private Long idClient;
    private String name;
    private String email;
    @Column(name="cell_phone")
    private String cellPhone;
}
