package com.example.price_alert.ProductShop.domain.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.ProductShop.domain.repository.ProductShopRepository;
import com.example.price_alert.Shop.domain.entity.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductShopQueryService {

    private final ProductShopRepository productShopRepository;

    @Transactional(readOnly = true)
    public ProductShop findByProductShopId(Long productShopId) {
        return productShopRepository.findById(productShopId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID로 productShop을 찾을 수 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<ProductShop> findAll() {
        return productShopRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ProductShop> findAllByProduct(Product product) {
        return productShopRepository.findByProduct(product);
    }

    @Transactional(readOnly = true)
    public ProductShop findByProductAndShop(Product product, Shop shop) {
        return productShopRepository.findByProductAndShop(product, shop)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품과 쇼핑몰 조합의 판매처를 찾을 수 없습니다."));
    }

}
