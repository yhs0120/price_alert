package com.example.price_alert.Shop.application.service;

import com.example.price_alert.Shop.application.dto.response.ShopResponse;
import com.example.price_alert.Shop.application.mapper.ShopMapper;
import com.example.price_alert.Shop.domain.entity.Shop;
import com.example.price_alert.Shop.domain.service.ShopQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopGetService {

    private final ShopQueryService shopQueryService;

    public ShopResponse.ShopInfoResponse getShop(Long shopId) {
        Shop shop = shopQueryService.findShopById(shopId);
        ShopResponse.ShopInfoResponse shopInfoResponse = ShopMapper.mapToShopResponse(shop);
        return shopInfoResponse;
    }

    public List<ShopResponse.ShopInfoResponse> getAllShops() {
        List<Shop> shopList = shopQueryService.findAll();

        return shopList.stream()
                .map(ShopMapper::mapToShopResponse)
                .collect(Collectors.toList());
    }

    public ShopResponse.ShopInfoResponse getShopByShopName(String shopName) {
        Shop shop = shopQueryService.findByShopName(shopName);
        ShopResponse.ShopInfoResponse shopInfoResponse = ShopMapper.mapToShopResponse(shop);
        return shopInfoResponse;
    }
}
