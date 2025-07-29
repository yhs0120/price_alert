package com.example.price_alert.Tracking.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TrackingRequest {

    @Getter
    @NoArgsConstructor
    public static class TrackingCreateRequest {
        @NotNull(message = "상품 ID는 필수입니다.")
        private Long productId;
        @NotNull(message = "목표 가격은 필수입니다.")
        @Positive(message = "목표 가격은 0보다 커야 합니다.")
        private Long target_price;

        @Builder
        public TrackingCreateRequest(Long productId, Long target_price) {
            this.productId = productId;
            this.target_price = target_price;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class TrackingUpdateRequest {
        private Long trackingId;
        @NotNull(message = "상품 ID는 필수입니다.")
        private Long productId;
        @NotNull(message = "목표 가격은 필수입니다.")
        @Positive(message = "목표 가격은 0보다 커야 합니다.")
        private Long target_price;

        @Builder
        public TrackingUpdateRequest(Long trackingId, Long productId, Long target_price) {
            this.trackingId = trackingId;
            this.productId = productId;
            this.target_price = target_price;
        }
    }
}
