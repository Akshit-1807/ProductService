package com.example.productservice.service;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreClientAdapter fakeStoreAdapter;
    FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter){
        this.fakeStoreAdapter = fakeStoreAdapter;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDto;
    }
//
//    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
//        this.restTemplateBuilder = restTemplateBuilder;
//    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException{
//        integrate the FakeStore API
//        RestTemplate
        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreAdapter.getAllProducts();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductsById(Long id) {
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductsById(id));
    }

    @Override
    public GenericProductDto createProducts(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.createProducts(genericProductDto));
    }

    @Override
    public void updateProductById() {

    }
}
