package com.example.price_alert.Product.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductRequest {

    @Getter
    @NoArgsConstructor
    public static class ProductCreateRequest {
        private String productName;
        private String productUrl;
        private Long targetPrice;

        @Builder
        public ProductCreateRequest(String productName, String productUrl, Long targetPrice) {
            this.productName = productName;
            this.productUrl = productUrl;
            this.targetPrice = targetPrice;
        }
    }
}
