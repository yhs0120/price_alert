package com.example.price_alert.PriceHistory.application.dto.response;

import com.example.price_alert.PriceHistory.domain.entity.StockStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PriceHistoryResponse {

    @Getter
    @NoArgsConstructor
    public static class PriceHistoryInfoResponse {
        private Long priceHistoryId;
        private Long price;
        private StockStatus stockStatus;
        private LocalDateTime recordedAt; // 기록된 시간 정보

        @Builder
        public PriceHistoryInfoResponse(Long priceHistoryId, Long price, StockStatus stockStatus, LocalDateTime recordedAt) {
            this.priceHistoryId = priceHistoryId;
            this.price = price;
            this.stockStatus = stockStatus;
            this.recordedAt = recordedAt;
        }
    }
}
