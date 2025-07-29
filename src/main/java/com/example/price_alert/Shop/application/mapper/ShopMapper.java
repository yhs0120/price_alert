package com.example.price_alert.Shop.application.mapper;

import com.example.price_alert.Shop.application.dto.request.ShopRequest;
import com.example.price_alert.Shop.application.dto.response.ShopResponse;
import com.example.price_alert.Shop.domain.entity.Shop;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShopMapper {

    public static Shop mapToShop(ShopRequest.ShopCreateRequest shopCreateRequest) {
        return Shop.builder()
                .shopName(shopCreateRequest.getShopName())
                .shopUrl(shopCreateRequest.getShopUrl())
                .build();
    }

    public static ShopResponse.ShopInfoResponse mapToShopResponse(Shop shop) {
        return ShopResponse.ShopInfoResponse.builder()
                .shopId(shop.getShopId())
                .shopName(shop.getShopName())
                .shopUrl(shop.getShopUrl())
                .build();
    }
}
