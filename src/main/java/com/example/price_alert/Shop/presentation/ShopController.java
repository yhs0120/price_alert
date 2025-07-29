package com.example.price_alert.Shop.presentation.controller;

import com.example.price_alert.Shop.application.dto.request.ShopRequest;
import com.example.price_alert.Shop.application.dto.response.ShopResponse.ShopInfoResponse;
import com.example.price_alert.Shop.application.service.ShopCreateService;
import com.example.price_alert.Shop.application.service.ShopGetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopCreateService shopCreateService;
    private final ShopGetService shopGetService;

    /**
     * 새로운 쇼핑몰 등록 API
     */
    @PostMapping
    public ResponseEntity<Void> createShop(@Valid @RequestBody ShopRequest.ShopCreateRequest request) {
        shopCreateService.createShop(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 모든 쇼핑몰 목록 조회 API
     */
    @GetMapping
    public ResponseEntity<List<ShopInfoResponse>> getAllShops() {
        List<ShopInfoResponse> shopList = shopGetService.getAllShops();
        return ResponseEntity.ok(shopList);
    }

    /**
     * 특정 ID의 쇼핑몰 정보 조회 API
     */
    @GetMapping("/{shopId}")
    public ResponseEntity<ShopInfoResponse> getShopById(@PathVariable Long shopId) {
        ShopInfoResponse shopInfo = shopGetService.getShop(shopId);
        return ResponseEntity.ok(shopInfo);
    }

    /**
     * 쇼핑몰 이름으로 정보 조회 API
     */
    @GetMapping("/by-name") // /api/shops/by-name?name=쇼핑몰이름
    public ResponseEntity<ShopInfoResponse> getShopByName(@RequestParam String name) {
        ShopInfoResponse shopInfo = shopGetService.getShopByShopName(name);
        return ResponseEntity.ok(shopInfo);
    }
}