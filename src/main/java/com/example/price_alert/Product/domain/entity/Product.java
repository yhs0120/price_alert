package com.example.price_alert.Product.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 추가
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName; // 상품명 (예: "GeForce RTX 4090")

    private String productUrl; // 상품 판매 페이지 URL

    private Long targetPrice; // 사용자가 원하는 목표 가격

    // 상품 등록 시 사용할 생성자
    @Builder
    public Product(String productName, String productUrl, Long targetPrice) {
        this.productName = productName;
        this.productUrl = productUrl;
        this.targetPrice = targetPrice;
    }
}