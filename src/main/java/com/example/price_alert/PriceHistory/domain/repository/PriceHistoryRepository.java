package com.example.price_alert.PriceHistory.domain.repository;

import com.example.price_alert.PriceHistory.domain.entity.PriceHistory;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
    // 1. 특정 판매처(ProductShop)의 모든 가격 이력을 '최신순'으로 정렬하여 조회
    List<PriceHistory> findByProductShopOrderByCreatedAtDesc(ProductShop productShop);

    // 2. 특정 판매처(ProductShop)의 가장 최신 가격 이력 '하나만' 조회
    Optional<PriceHistory> findFirstByProductShopOrderByCreatedAtDesc(ProductShop productShop);
}
