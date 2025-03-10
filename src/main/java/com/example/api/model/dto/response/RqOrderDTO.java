package com.example.api.model.dto.response;

import com.example.api.model.dto.ClientDTO;
import com.example.api.model.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RqOrderDTO {
    private int  amount;
    @JsonProperty("date_order")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOrder;
    @JsonProperty("id_client")
    private Long idClient;
    @JsonProperty("id_product")
    private Long idProduct;
}
