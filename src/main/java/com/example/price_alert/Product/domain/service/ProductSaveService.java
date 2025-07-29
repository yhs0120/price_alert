package com.example.price_alert.Product.domain.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductSaveService {
    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
