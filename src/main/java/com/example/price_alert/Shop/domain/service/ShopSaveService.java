package com.example.price_alert.Shop.domain.service;

import com.example.price_alert.Shop.domain.entity.Shop;
import com.example.price_alert.Shop.domain.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopSaveService {

    private final ShopRepository shopRepository;

    public void saveShop(Shop shop) {
        shopRepository.save(shop);
    }
}
