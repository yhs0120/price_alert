package com.example.price_alert.Product.domain.repository;

import com.example.price_alert.Product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 상품 이름(productName)에 특정 키워드가 포함된 상품들을 조회 (대소문자 무시)
    // 예: 'iphone'으로 검색 시 'iPhone 15', 'iphone 15 pro' 모두 검색됨
    List<Product> findByProductNameContainingIgnoreCase(String keyword);
}
