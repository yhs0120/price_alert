package com.example.price_alert.PriceHistory.application.dto.request;

import com.example.price_alert.PriceHistory.domain.entity.StockStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PriceHistoryRequest {
    @Getter
    @NoArgsConstructor
    public static class PriceHistoryCreateRequest {

        @NotNull(message = "판매처 ID는 필수입니다.")
        private Long productShopId;

        @NotNull(message = "가격은 필수입니다.")
        @PositiveOrZero(message = "가격은 0 이상이어야 합니다.")
        private Long price;

        @NotNull(message = "재고 상태는 필수입니다.")
        private StockStatus stockStatus;

        private LocalDateTime recordedAt;

        @Builder
        public PriceHistoryCreateRequest(Long productShopId, Long price, StockStatus stockStatus, LocalDateTime recordedAt) {
            this.productShopId = productShopId;
            this.price = price;
            this.stockStatus = stockStatus;
            this.recordedAt = recordedAt;
        }
    }
}