package com.example.price_alert.Tracking.application.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Product.domain.service.ProductQueryService;
import com.example.price_alert.Tracking.application.dto.response.TrackingResponse;
import com.example.price_alert.Tracking.application.mapper.TrackingMapper;
import com.example.price_alert.Tracking.domain.entity.Tracking;
import com.example.price_alert.Tracking.domain.service.TrackingQueryService;
import com.example.price_alert.User.domain.entity.User;
import com.example.price_alert.User.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackingGetService {

    private final TrackingQueryService trackingQueryService;
    private final ProductQueryService productQueryService;
    private final UserQueryService userQueryService;

    public TrackingResponse.TrackingInfoResponse getTrackingInfo(Long trackingId) {
        Tracking tracking = trackingQueryService.findTrackingById(trackingId);
        TrackingResponse.TrackingInfoResponse trackingInfoResponse = TrackingMapper.mapToTrackingResponse(tracking);

        return trackingInfoResponse;
    }

    public List<TrackingResponse.TrackingInfoResponse> findAllByUser(Long userId) {
        User user = userQueryService.findUserById(userId);
        List<Tracking> trackingList = trackingQueryService.findAllByUser(user);
        List<TrackingResponse.TrackingInfoResponse> trackingInfoResponseList = trackingList.stream()
                .map(TrackingMapper::mapToTrackingResponse)
                .collect(Collectors.toList());

        return trackingInfoResponseList;
    }

    public boolean checkIfUserIsTrackingProduct(Long userId, Long productId) {
        // 1. 필요한 엔티티들을 각 도메인 서비스에서 조회
        User user = userQueryService.findUserById(userId);
        Product product = productQueryService.findProductById(productId);

        // 2. TrackingQueryService에 조회 로직 위임
        return trackingQueryService.isUserTrackingProduct(user, product);
    }
}
