package com.example.price_alert.Product.application.mapper;

import com.example.price_alert.Product.application.dto.request.ProductRequest;
import com.example.price_alert.Product.application.dto.response.ProductResponse;
import com.example.price_alert.Product.domain.entity.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

    public static Product mapToProduct(ProductRequest.ProductCreateRequest productCreateRequest) {
        return Product.builder()
                .productName(productCreateRequest.getProductName())
                .productUrl(productCreateRequest.getProductUrl())
                .targetPrice(productCreateRequest.getTargetPrice())
                .build();
    }

    public static ProductResponse.ProductInfoResponse mapToProductInfoResponse(Product product) {
        return ProductResponse.ProductInfoResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productUrl(product.getProductUrl())
                .targetPrice(product.getTargetPrice())
                .build();
    }
    public static ProductResponse.SimpleProductInfo mapToProductSimpleProductInfo(Product product) {
        return ProductResponse.SimpleProductInfo.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .build();
    }
}
