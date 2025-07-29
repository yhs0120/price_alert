package com.example.price_alert.Tracking.domain.repository;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Tracking.domain.entity.Tracking;
import com.example.price_alert.User.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    // 1. 특정 사용자가 추적하는 모든 정보를 조회
    // 메서드 이름 그대로 'User 엔티티를 기준으로 Tracking을 찾아줘' 라는 쿼리가 생성됩니다.
    List<Tracking> findByUser(User user);

    // 2. 특정 사용자가 특정 상품을 추적하고 있는지 확인
    // 'User와 Product를 기준으로 Tracking을 찾아줘' 라는 쿼리가 생성됩니다.
    // 결과가 없을 수도 있으므로 Optional로 감싸는 것이 안전합니다.
    Optional<Tracking> findByUserAndProduct(User user, Product product);
}
