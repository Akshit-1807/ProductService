package com.example.productservice.controllers;

import com.example.productservice.service.FakeStoreProductService;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    //@Autowired OPTIONAL
    //constructor injection
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){
        //call the FakeStoreProductService getProductById() method
        //return "Scaler || product with id: " + id;
        return productService.getProductById(id);
    }
    @GetMapping()
    public void getAllProducts(){

    }
    @DeleteMapping("{id}")
    public void deleteProductById(){

    }
    public void createProduct(){

    }
    public void updateProductById(){

    }
}

/*
3 ways of Dependency Injection :-

1. CONSTRUCTOR INJECTION
2. FIELD INJECTION
3. SETTER INJECTION
 */