package com.example.price_alert.Tracking.presentation;

import com.example.price_alert.Tracking.application.dto.request.TrackingRequest;
import com.example.price_alert.Tracking.application.dto.response.TrackingResponse;
import com.example.price_alert.Tracking.application.service.TrackingCreateService;
import com.example.price_alert.Tracking.application.service.TrackingGetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trackings")
public class TrackingController {

    private final TrackingCreateService trackingCreateService;
    private final TrackingGetService trackingGetService;

    /**
     * 가격 추적 생성 API
     */
    @PostMapping
    public ResponseEntity<Void> createTracking(@Valid @RequestBody TrackingRequest.TrackingCreateRequest request) {
        // TODO: 실제로는 Spring Security의 SecurityContext에서 로그인한 사용자 ID를 가져와야 합니다.
        Long currentUserId = 1L; // 임시 사용자 ID

        trackingCreateService.createTracking(request, currentUserId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 현재 로그인한 사용자의 모든 추적 목록 조회 API
     */
    @GetMapping
    public ResponseEntity<List<TrackingResponse.TrackingInfoResponse>> getMyTrackings() {
        // TODO: 실제로는 SecurityContext에서 로그인한 사용자 ID를 가져와야 합니다.
        Long currentUserId = 1L; // 임시 사용자 ID

        // 이전에 제안했던, userId를 받는 서비스 메서드 사용
        List<TrackingResponse.TrackingInfoResponse> response = trackingGetService.findAllByUser(currentUserId);
        return ResponseEntity.ok(response);
    }

    /**
     * 특정 상품에 대한 추적 여부 확인 API
     */
    @GetMapping("/status") // ex: /api/trackings/status?productId=10
    public ResponseEntity<Boolean> getTrackingStatus(@RequestParam Long productId) {
        // TODO: 실제로는 SecurityContext에서 로그인한 사용자 ID를 가져와야 합니다.
        Long currentUserId = 1L; // 임시 사용자 ID

        boolean isTracking = trackingGetService.checkIfUserIsTrackingProduct(currentUserId, productId);
        return ResponseEntity.ok(isTracking);
    }
}