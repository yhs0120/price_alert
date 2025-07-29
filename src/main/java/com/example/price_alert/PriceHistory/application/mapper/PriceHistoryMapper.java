package com.example.price_alert.PriceHistory.application.mapper;

import com.example.price_alert.PriceHistory.application.dto.request.PriceHistoryRequest;
import com.example.price_alert.PriceHistory.application.dto.response.PriceHistoryResponse;
import com.example.price_alert.PriceHistory.domain.entity.PriceHistory;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PriceHistoryMapper {

    public static PriceHistory mapToPriceHistory(PriceHistoryRequest.PriceHistoryCreateRequest priceHistoryCreateRequest, ProductShop productShop) {
        return PriceHistory.builder()
                .price(priceHistoryCreateRequest.getPrice())
                .productShop(productShop)
                .recordedAt(priceHistoryCreateRequest.getRecordedAt())
                .stockStatus(priceHistoryCreateRequest.getStockStatus())
                .build();
    }

    public static PriceHistoryResponse.PriceHistoryInfoResponse mapToPriceHistoryInfo(PriceHistory priceHistory) {
        return PriceHistoryResponse.PriceHistoryInfoResponse.builder()
                .priceHistoryId(priceHistory.getPriceHistoryId())
                .price(priceHistory.getPrice())
                .recordedAt(priceHistory.getRecordedAt())
                .stockStatus(priceHistory.getStockStatus())
                .build();
    }
}
