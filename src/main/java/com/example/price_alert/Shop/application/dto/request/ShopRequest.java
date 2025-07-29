package com.example.price_alert.Shop.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ShopRequest {
    @Getter
    @NoArgsConstructor
    public static class ShopCreateRequest {
        private String shopName;
        private String shopUrl;

        @Builder
        public ShopCreateRequest(String shopName, String shopUrl) {
            this.shopName = shopName;
            this.shopUrl = shopUrl;
        }
    }
}
