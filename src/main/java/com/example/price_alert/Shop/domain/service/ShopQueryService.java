package com.example.price_alert.Shop.domain.service;

import com.example.price_alert.Shop.domain.entity.Shop;
import com.example.price_alert.Shop.domain.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopQueryService {

    private final ShopRepository shopRepository;

    @Transactional(readOnly = true)
    public Shop findShopById(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID로 쇼핑몰을 검색할 수 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Shop findByShopName(String shopName) {
        return shopRepository.findByShopName(shopName)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름으로 쇼핑몰을 검색할 수 없습니다."));
    }


}
