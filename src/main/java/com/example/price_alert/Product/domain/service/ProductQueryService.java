package com.example.price_alert.Product.domain.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductRepository productRepository;

    // 추가 기능 1: ID로 특정 상품 조회
    @Transactional(readOnly = true)
    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 상품이 없습니다: " + productId));
    }

    // 추가 기능 2: 전체 상품 목록 조회
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // 추가 기능 3: 이름 키워드로 상품 검색
    @Transactional(readOnly = true)
    public List<Product> searchProductsByName(String keyword) {
        return productRepository.findByProductNameContainingIgnoreCase(keyword);
    }
}
