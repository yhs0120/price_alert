package com.example.price_alert.Tracking.application.mapper;

import com.example.price_alert.Product.application.dto.response.ProductResponse;
import com.example.price_alert.Product.application.mapper.ProductMapper;
import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Tracking.application.dto.request.TrackingRequest;
import com.example.price_alert.Tracking.application.dto.response.TrackingResponse;
import com.example.price_alert.Tracking.domain.entity.Tracking;
import com.example.price_alert.User.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrackingMapper {

    public static Tracking mapToTracking(TrackingRequest.TrackingCreateRequest trackingCreateRequest, Product product, User user) {
        return Tracking.builder()
                .target_price(trackingCreateRequest.getTarget_price())
                .product(product)
                .user(user)
                .build();
    }

    public static TrackingResponse.TrackingInfoResponse mapToTrackingResponse(Tracking tracking) {
        // 1. Tracking 엔티티에서 Product 엔티티를 가져옵니다.
        Product product = tracking.getProduct();

        // 2. Product 엔티티를 ProductResponse.SimpleProductInfo DTO로 변환합니다.
        //    (ProductResponse에 mapToProductSimpleProductInfo 메서드가 있다고 가정)
        ProductResponse.SimpleProductInfo productInfoDTO = ProductMapper.mapToProductSimpleProductInfo(product);

        return TrackingResponse.TrackingInfoResponse.builder()
                .trackingId(tracking.getTrackingId())
                .productInfo(productInfoDTO)
                .target_price(tracking.getTarget_price())
                .build();
    }

}