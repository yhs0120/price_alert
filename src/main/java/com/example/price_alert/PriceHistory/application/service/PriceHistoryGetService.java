package com.example.price_alert.PriceHistory.application.service;

import com.example.price_alert.PriceHistory.application.dto.response.PriceHistoryResponse.PriceHistoryInfoResponse;
import com.example.price_alert.PriceHistory.application.mapper.PriceHistoryMapper;
import com.example.price_alert.PriceHistory.domain.entity.PriceHistory;
import com.example.price_alert.PriceHistory.domain.service.PriceHistoryQueryService;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.ProductShop.domain.service.ProductShopQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceHistoryGetService {

    private final PriceHistoryQueryService priceHistoryQueryService;
    private final ProductShopQueryService productShopQueryService;

    /**
     * 특정 판매처의 모든 가격 변동 이력을 최신순으로 조회합니다.
     * @param productShopId 조회할 판매처의 ID
     * @return 가격 이력 DTO 리스트
     */
    @Transactional(readOnly = true)
    public List<PriceHistoryInfoResponse> getAllPriceHistoryForProductShop(Long productShopId) {
        // 1. ID로 ProductShop 엔티티를 조회합니다.
        ProductShop productShop = productShopQueryService.findByProductShopId(productShopId);

        // 2. 조회한 엔티티로 모든 가격 이력을 가져옵니다.
        List<PriceHistory> historyList = priceHistoryQueryService.findAllByProductShop(productShop);

        // 3. DTO 리스트로 변환하여 반환합니다.
        return historyList.stream()
                .map(PriceHistoryMapper::mapToPriceHistoryInfo)
                .collect(Collectors.toList());
    }

    /**
     * 특정 판매처의 가장 최신 가격 정보를 조회합니다.
     * @param productShopId 조회할 판매처의 ID
     * @return 최신 가격 정보 DTO
     */
    @Transactional(readOnly = true)
    public PriceHistoryInfoResponse getLatestPriceForProductShop(Long productShopId) {
        // 1. ID로 ProductShop 엔티티를 조회합니다.
        ProductShop productShop = productShopQueryService.findByProductShopId(productShopId);

        // 2. 조회한 엔티티로 가장 최신 가격 이력을 가져옵니다.
        PriceHistory latestPriceHistory = priceHistoryQueryService.findLatestByProductShop(productShop);

        // 3. DTO로 변환하여 반환합니다.
        PriceHistoryInfoResponse priceHistoryInfoResponse = PriceHistoryMapper.mapToPriceHistoryInfo(latestPriceHistory);

        return priceHistoryInfoResponse;
    }
}