package com.example.productservice.thirdPartyClients.fakeStoreClient;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreUrl;

    private String pathForProducts;
    private String specificProductUrl;

    private String genericProductsUrl;

    FakeStoreClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}")String fakeStoreUrl, @Value("${fakestore.api.paths.products}")String pathForProducts)
    {
        this.restTemplateBuilder = restTemplateBuilder;
        this.genericProductsUrl = fakeStoreUrl + pathForProducts;
        this.specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException{
        //integrate the FakeStore API
        //RestTemplate
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if (fakeStoreProductDto == null){
            //Throw an exception
            throw new ProductNotFoundException("Product with id "+ id + " does not exist");
        }


        //Convert FakeStoreProductDto to GenericProductDto before returning
        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductsUrl, FakeStoreProductDto[].class);

        //ArrayList<Integer> => ArrayList.class -> Erasure

        return List.of(responseEntity.getBody());

    }

    public FakeStoreProductDto deleteProductsById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
        //return null;
    }

    public FakeStoreProductDto createProducts(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductsUrl, genericProductDto, FakeStoreProductDto.class);

        //GenericProductDto genericProductDto1= convertToGenericProductDto(responseEntity.getBody());
        return responseEntity.getBody();
    }

    public void updateProductById() {

    }

}
