package com.example.price_alert.Tracking.domain.service;

import com.example.price_alert.Tracking.domain.entity.Tracking;
import com.example.price_alert.Tracking.domain.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingSaveService {

    private final TrackingRepository trackingRepository;

    public void saveTracking(Tracking tracking) {
        trackingRepository.save(tracking);
    }
}
