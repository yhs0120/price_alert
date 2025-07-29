package com.example.price_alert.Tracking.application.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.service.ProductQueryService;
import com.example.price_alert.Tracking.application.dto.request.TrackingRequest;
import com.example.price_alert.Tracking.application.mapper.TrackingMapper;
import com.example.price_alert.Tracking.domain.entity.Tracking;
import com.example.price_alert.Tracking.domain.service.TrackingSaveService;
import com.example.price_alert.User.domain.entity.User;
import com.example.price_alert.User.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingCreateService {

    private final TrackingSaveService trackingSaveService;
    private final ProductQueryService productQueryService;
    private final UserQueryService userQueryService;

    public void createTracking(TrackingRequest.TrackingCreateRequest trackingCreateRequest, Long userId) {
        Long productId = trackingCreateRequest.getProductId();
        Product product = productQueryService.findProductById(productId);
        User user = userQueryService.findUserById(userId);
        Tracking tracking = TrackingMapper.mapToTracking(trackingCreateRequest, product, user);
        trackingSaveService.saveTracking(tracking);
    }

}
