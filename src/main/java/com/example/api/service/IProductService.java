package com.example.api.service;

import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.dto.ProductDTO;

public interface IProductService {
    public GeneralResponseDTO getAllProducts();
    public GeneralResponseDTO getProductById(Long id);
    public GeneralResponseDTO saveProduct(ProductDTO product);
    public GeneralResponseDTO updateProduct(Long id, ProductDTO product);
    public GeneralResponseDTO deleteProduct(Long id);

}
