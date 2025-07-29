package com.example.price_alert.ProductShop.application.dto.response;

import com.example.price_alert.Product.application.dto.response.ProductResponse;
import com.example.price_alert.Shop.application.dto.response.ShopResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductShopResponse {
    @Getter
    @NoArgsConstructor
    public static class ProductShopInfoResponse {
        private Long productShopId;

        private ProductResponse.SimpleProductInfo product;
        private ShopResponse.ShopInfoResponse shop;
        @Builder
        public ProductShopInfoResponse(Long productShopId, ProductResponse.SimpleProductInfo product, ShopResponse.ShopInfoResponse shop) {
            this.productShopId = productShopId;
            this.product = product;
            this.shop = shop;
        }
    }
}
