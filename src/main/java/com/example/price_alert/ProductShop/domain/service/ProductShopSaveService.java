package com.example.price_alert.ProductShop.domain.service;

import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.ProductShop.domain.repository.ProductShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductShopSaveService {

    private final ProductShopRepository productShopRepository;

    public void saveProductShop(ProductShop productShop) {
        productShopRepository.save(productShop);
    }
}
