package com.example.price_alert.Shop.application.service;

import com.example.price_alert.Shop.application.dto.request.ShopRequest;
import com.example.price_alert.Shop.application.mapper.ShopMapper;
import com.example.price_alert.Shop.domain.entity.Shop;
import com.example.price_alert.Shop.domain.service.ShopSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopCreateService {

    private final ShopSaveService shopSaveService;

    public void createShop(ShopRequest.ShopCreateRequest shopCreateRequest) {
        Shop shop = ShopMapper.mapToShop(shopCreateRequest);
        shopSaveService.saveShop(shop);
    }
}
