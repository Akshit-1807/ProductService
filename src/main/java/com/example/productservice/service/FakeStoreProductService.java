package com.example.productservice.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    @Override
    public String getProductById(Long id) {
        //integrate the FakeStore API
        //RestTemplate

        RestTemplate template = new RestTemplate();
        return "Scaler || product with id: " + id;
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductsById() {

    }

    @Override
    public void createProducts() {

    }

    @Override
    public void updateProductById() {

    }
}
