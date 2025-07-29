package com.example.price_alert.ProductShop.application.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.service.ProductQueryService;
import com.example.price_alert.ProductShop.application.dto.response.ProductShopResponse;
import com.example.price_alert.ProductShop.application.mapper.ProductShopMapper;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.ProductShop.domain.service.ProductShopQueryService;
import com.example.price_alert.Shop.domain.service.ShopQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductShopGetService {
    // 필요한 모든 QueryService를 주입받습니다.
    private final ProductShopQueryService productShopQueryService;
    private final ProductQueryService productQueryService;
    private final ShopQueryService shopQueryService;

    /**
     * 특정 상품을 판매하는 모든 판매처(쇼핑몰) 목록을 조회합니다.
     * @param productId 조회할 상품의 ID
     * @return 해당 상품의 판매처 정보 DTO 리스트
     */
    @Transactional(readOnly = true)
    public List<ProductShopResponse.ProductShopInfoResponse> getAllShopsForProduct(Long productId) {
        // 1. productId로 Product 엔티티를 조회합니다.
        Product product = productQueryService.findProductById(productId);

        // 2. 조회한 Product 엔티티로 ProductShop 목록을 조회합니다.
        List<ProductShop> productShopList = productShopQueryService.findAllByProduct(product);

        // 3. 조회된 목록을 DTO 리스트로 변환하여 반환합니다.
        return productShopList.stream()
                .map(ProductShopMapper::mapToProductShopInfoResponse)
                .collect(Collectors.toList());
    }

    /**
     * 특정 상품-쇼핑몰 관계(판매처)의 상세 정보를 조회합니다.
     * @param productShopId 조회할 판매처의 고유 ID
     * @return 판매처 정보 DTO
     */
    @Transactional(readOnly = true)
    public ProductShopResponse.ProductShopInfoResponse getProductShopInfo(Long productShopId) {
        ProductShop productShop = productShopQueryService.findByProductShopId(productShopId);
        return ProductShopMapper.mapToProductShopInfoResponse(productShop);
    }

    /**
     * 모든 판매처 정보 목록을 조회합니다.
     * @return 모든 판매처 정보 DTO 리스트
     */
    @Transactional(readOnly = true)
    public List<ProductShopResponse.ProductShopInfoResponse> getAllProductShops() {
        List<ProductShop> allProductShops = productShopQueryService.findAll();

        return allProductShops.stream()
                .map(ProductShopMapper::mapToProductShopInfoResponse)
                .collect(Collectors.toList());
    }

}
