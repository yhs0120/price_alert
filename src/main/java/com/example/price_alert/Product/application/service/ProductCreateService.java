package com.example.price_alert.Product.application.service;

import com.example.price_alert.Product.application.dto.request.ProductRequest;
import com.example.price_alert.Product.application.mapper.ProductMapper;
import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.service.ProductSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateService {

    private final ProductSaveService productSaveService;


    public void createProduct(ProductRequest.ProductCreateRequest productCreateRequest) {
        Product product = ProductMapper.mapToProduct(productCreateRequest);
        productSaveService.saveProduct(product);
    }
}
