package com.example.price_alert.Product.presentation;

import com.example.price_alert.Product.application.dto.request.ProductRequest;
import com.example.price_alert.Product.application.dto.response.ProductResponse.ProductInfoResponse;
import com.example.price_alert.Product.application.service.ProductCreateService;
import com.example.price_alert.Product.application.service.ProductGetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductCreateService productCreateService;
    private final ProductGetService productGetService;

    /**
     * 새로운 상품 등록 API
     */
    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductRequest.ProductCreateRequest request) {
        productCreateService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 모든 상품 목록 조회 API
     */
    @GetMapping
    public ResponseEntity<List<ProductInfoResponse>> getAllProducts() {
        List<ProductInfoResponse> productList = productGetService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    /**
     * 키워드로 상품 검색 API
     * 예: /api/products/search?keyword=갤럭시
     */
    @GetMapping("/search")
    public ResponseEntity<List<ProductInfoResponse>> searchProducts(@RequestParam String keyword) {
        List<ProductInfoResponse> productList = productGetService.searchProducts(keyword);
        return ResponseEntity.ok(productList);
    }

    /**
     * ID로 특정 상품 정보 조회 API
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductInfoResponse> getProductById(@PathVariable Long productId) {
        ProductInfoResponse productInfo = productGetService.getProductInfo(productId);
        return ResponseEntity.ok(productInfo);
    }
}