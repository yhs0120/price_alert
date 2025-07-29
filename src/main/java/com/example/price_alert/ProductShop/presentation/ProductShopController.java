package com.example.price_alert.ProductShop.presentation;

import com.example.price_alert.ProductShop.application.dto.request.ProductShopRequest;
import com.example.price_alert.ProductShop.application.dto.response.ProductShopResponse.ProductShopInfoResponse;
import com.example.price_alert.ProductShop.application.service.ProductShopCreateService;
import com.example.price_alert.ProductShop.application.service.ProductShopGetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-shops")
public class ProductShopController {

    private final ProductShopCreateService productShopCreateService;
    private final ProductShopGetService productShopGetService;

    /**
     * 상품과 쇼핑몰 연결(판매처) 생성 API
     */
    @PostMapping
    public ResponseEntity<Void> createProductShop(@Valid @RequestBody ProductShopRequest.ProductShopCreateRequest request) {
        productShopCreateService.createProductShop(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 특정 상품의 모든 판매처 목록 조회 API
     * 예: /api/product-shops/by-product?productId=1
     */
    @GetMapping("/by-product")
    public ResponseEntity<List<ProductShopInfoResponse>> getShopsForProduct(@RequestParam Long productId) {
        List<ProductShopInfoResponse> response = productShopGetService.getAllShopsForProduct(productId);
        return ResponseEntity.ok(response);
    }

    /**
     * 특정 판매처 정보 상세 조회 API
     */
    @GetMapping("/{productShopId}")
    public ResponseEntity<ProductShopInfoResponse> getProductShopById(@PathVariable Long productShopId) {
        ProductShopInfoResponse response = productShopGetService.getProductShopInfo(productShopId);
        return ResponseEntity.ok(response);
    }

    /**
     * (주의) 모든 판매처 정보 목록 조회 API
     */
    @GetMapping
    public ResponseEntity<List<ProductShopInfoResponse>> getAllProductShops() {
        List<ProductShopInfoResponse> response = productShopGetService.getAllProductShops();
        return ResponseEntity.ok(response);
    }
}