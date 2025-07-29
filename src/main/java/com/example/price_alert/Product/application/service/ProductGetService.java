package com.example.price_alert.Product.application.service;

import com.example.price_alert.Product.application.dto.response.ProductResponse.ProductInfoResponse;
import com.example.price_alert.Product.application.mapper.ProductMapper;
import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductGetService {

    private final ProductQueryService productQueryService;

    /**
     * ID로 특정 상품의 정보를 조회합니다.
     */
    @Transactional(readOnly = true)
    public ProductInfoResponse getProductInfo(Long productId) {
        Product product = productQueryService.findProductById(productId);
        return ProductMapper.mapToProductInfoResponse(product);
    }

    /**
     *  모든 상품 목록을 조회합니다.
     */
    @Transactional(readOnly = true)
    public List<ProductInfoResponse> getAllProducts() {
        List<Product> productList = productQueryService.findAll();
        return productList.stream()
                .map(ProductMapper::mapToProductInfoResponse)
                .collect(Collectors.toList());
    }

    /**
     * 키워드로 상품 이름을 검색합니다.
     */
    @Transactional(readOnly = true)
    public List<ProductInfoResponse> searchProducts(String keyword) {
        List<Product> productList = productQueryService.searchProductsByName(keyword);
        return productList.stream()
                .map(ProductMapper::mapToProductInfoResponse)
                .collect(Collectors.toList());
    }
}