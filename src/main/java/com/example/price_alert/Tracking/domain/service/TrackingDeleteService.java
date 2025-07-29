package com.example.price_alert.Tracking.domain.service;

import com.example.price_alert.Tracking.domain.entity.Tracking;
import com.example.price_alert.Tracking.domain.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingDeleteService {

    private final TrackingRepository trackingRepository;

    public void deleteTracking(Tracking tracking) {
        trackingRepository.delete(tracking);
    }
}
