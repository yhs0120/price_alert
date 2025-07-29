package com.example.price_alert.PriceHistory.domain.service;

import com.example.price_alert.PriceHistory.domain.entity.PriceHistory;
import com.example.price_alert.PriceHistory.domain.repository.PriceHistoryRepository;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceHistoryQueryService {

    private final PriceHistoryRepository priceHistoryRepository;

    // ✨추가 기능 1: 특정 판매처의 모든 가격 이력을 최신순으로 조회
    public List<PriceHistory> findAllByProductShop(ProductShop productShop) {
        return priceHistoryRepository.findByProductShopOrderByCreatedAtDesc(productShop);
    }

    // ✨추가 기능 2: 특정 판매처의 가장 최신 가격 정보 조회
    public PriceHistory findLatestByProductShop(ProductShop productShop) {
        return priceHistoryRepository.findFirstByProductShopOrderByCreatedAtDesc(productShop)
                .orElseThrow(() -> new IllegalArgumentException("해당 판매처의 가격 이력이 없습니다."));
    }
}
