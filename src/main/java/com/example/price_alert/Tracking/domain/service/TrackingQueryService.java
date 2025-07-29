package com.example.price_alert.Tracking.domain.service;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Tracking.domain.entity.Tracking;
import com.example.price_alert.Tracking.domain.repository.TrackingRepository;
import com.example.price_alert.User.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackingQueryService {

    private final TrackingRepository trackingRepository;


    @Transactional(readOnly = true)
    public Tracking findTrackingById(Long trackingId) {
        return trackingRepository.findById(trackingId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID 추적 기록 검색을 할 수 없습니다." + trackingId));
    }

    // [추가 기능 1] 특정 사용자의 모든 추적 목록 조회
    @Transactional(readOnly = true)
    public List<Tracking> findAllByUser(User user) {
        return trackingRepository.findByUser(user);
    }

    // [추가 기능 2] 특정 사용자가 특정 상품을 추적 중인지 확인
    @Transactional(readOnly = true)
    public boolean isUserTrackingProduct(User user, Product product) {
        // findByUserAndProduct 결과가 존재하면 true, 아니면 false를 반환
        return trackingRepository.findByUserAndProduct(user, product).isPresent();
    }

}
