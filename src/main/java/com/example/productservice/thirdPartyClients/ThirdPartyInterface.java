package com.example.productservice.thirdPartyClients;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ThirdPartyInterface {
    GenericProductDto getProductById(Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductsById(Long id);
    GenericProductDto createProducts(GenericProductDto genericProductDto);
    void updateProductById();
}
