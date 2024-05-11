package com.example.productservice.controllers;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.service.FakeStoreProductService;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @GetMapping()
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable("id")Long id){
        return productService.deleteProductsById(id);

        //return null;
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProducts(genericProductDto);
    }

    @PatchMapping("{/id}")
    public void updateProductById(@PathVariable("id")Long id){

    }
}

/*
3 ways of Dependency Injection :-

1. CONSTRUCTOR INJECTION
2. FIELD INJECTION
3. SETTER INJECTION
 */