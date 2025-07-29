package com.example.price_alert.ProductShop.application.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.service.ProductQueryService;
import com.example.price_alert.ProductShop.application.dto.request.ProductShopRequest;
import com.example.price_alert.ProductShop.application.mapper.ProductShopMapper;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.ProductShop.domain.service.ProductShopQueryService;
import com.example.price_alert.ProductShop.domain.service.ProductShopSaveService;
import com.example.price_alert.Shop.domain.entity.Shop;
import com.example.price_alert.Shop.domain.service.ShopQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductShopCreateService {
    private final ProductShopSaveService productShopSaveService;
    private final ProductQueryService productQueryService;
    private final ShopQueryService shopQueryService;
    private final ProductShopQueryService productShopQueryService;

    public void createProductShop(ProductShopRequest.ProductShopCreateRequest productShopCreateRequest) {
        Product product = productQueryService.findProductById(productShopCreateRequest.getProductId());
        Shop shop = shopQueryService.findShopById(productShopCreateRequest.getShopId());
        // 2. ✅ findByProductAndShop를 이용해 중복 여부 확인
        try {
            productShopQueryService.findByProductAndShop(product, shop);
            // 예외가 발생하지 않으면 이미 존재하는 것이므로, 중복 에러를 발생시킴
            throw new IllegalStateException("이미 등록된 판매처 정보입니다.");
        } catch (IllegalArgumentException e) {
            // "찾을 수 없습니다" 예외가 발생하면, 없는 것이므로 정상적으로 생성 진행
        }
        ProductShop productShop = ProductShopMapper.mapToProductShop(productShopCreateRequest, product, shop);
        productShopSaveService.saveProductShop(productShop);
    }
}
