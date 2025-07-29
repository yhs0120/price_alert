package com.example.price_alert.Product.application.dto.response;

import com.example.price_alert.Product.domain.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductResponse {

    @Getter
    @NoArgsConstructor
    public static class ProductInfoResponse {
        private Long productId;
        private String productName;
        private String productUrl;
        private Long targetPrice;

        @Builder
        public ProductInfoResponse(Long productId, String productName, String productUrl, Long targetPrice) {
            this.productId = productId;
            this.productName = productName;
            this.productUrl = productUrl;
            this.targetPrice = targetPrice;
        }
    }
    @Getter
    @NoArgsConstructor
    public static class SimpleProductInfo {

        private Long productId;
        private String productName;
        // 필요하다면 이미지 URL 등 추가
        @Builder
        public SimpleProductInfo(Long productId, String productName) {
            this.productId = productId;
            this.productName = productName;
        }
    }
}

