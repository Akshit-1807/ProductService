package com.example.productservice.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    String getProductById(Long id);
    void getAllProducts();
    void deleteProductsById();
    void createProducts();
    void updateProductById();
}
