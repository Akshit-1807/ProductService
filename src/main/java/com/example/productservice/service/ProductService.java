package com.example.productservice.service;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    GenericProductDto getProductById(Long id);
    void getAllProducts();
    void deleteProductsById();
    void createProducts();
    void updateProductById();
}
