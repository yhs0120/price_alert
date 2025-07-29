package com.example.price_alert.Tracking.application.dto.response;

import com.example.price_alert.Product.application.dto.response.ProductResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TrackingResponse {

    @Getter
    @NoArgsConstructor
    public static class TrackingInfoResponse {
        private Long trackingId;
        private Long target_price;
        private ProductResponse.SimpleProductInfo productInfo;

        @Builder
        public TrackingInfoResponse(Long trackingId, Long target_price, ProductResponse.SimpleProductInfo productInfo) {
            this.trackingId = trackingId;
            this.target_price = target_price;
            this.productInfo = productInfo;
        }
    }
}
