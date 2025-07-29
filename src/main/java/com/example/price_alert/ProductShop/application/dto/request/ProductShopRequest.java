package com.example.price_alert.ProductShop.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductShopRequest {
    @Getter
    @NoArgsConstructor
    public static class ProductShopCreateRequest {
        private Long productId;
        private Long shopId;

        @Builder
        public ProductShopCreateRequest(Long productId, Long shopId) {
            this.productId = productId;
            this.shopId = shopId;
        }
    }

}
