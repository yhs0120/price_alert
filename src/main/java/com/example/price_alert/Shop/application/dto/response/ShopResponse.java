package com.example.price_alert.Shop.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ShopResponse {

    @Getter
    @NoArgsConstructor
    public static class ShopInfoResponse {
        private Long shopId;
        private String shopName;
        private String shopUrl;

        @Builder
        public ShopInfoResponse(Long shopId, String shopName, String shopUrl) {
            this.shopId = shopId;
            this.shopName = shopName;
            this.shopUrl = shopUrl;
        }
    }
}
