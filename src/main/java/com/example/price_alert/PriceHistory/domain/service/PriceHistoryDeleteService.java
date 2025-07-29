package com.example.price_alert.PriceHistory.domain.service;

import com.example.price_alert.PriceHistory.domain.entity.PriceHistory;
import com.example.price_alert.PriceHistory.domain.repository.PriceHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceHistoryDeleteService {

    private final PriceHistoryRepository priceHistoryRepository;

    public void deletePriceHistory(PriceHistory priceHistory) {
        priceHistoryRepository.delete(priceHistory);
    }
}
