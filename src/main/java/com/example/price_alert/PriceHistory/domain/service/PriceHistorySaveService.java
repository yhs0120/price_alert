package com.example.price_alert.PriceHistory.domain.service;

import com.example.price_alert.PriceHistory.domain.entity.PriceHistory;
import com.example.price_alert.PriceHistory.domain.repository.PriceHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceHistorySaveService {

    private final PriceHistoryRepository priceHistoryRepository;

    public void savePriceHistory(PriceHistory priceHistory) {
        priceHistoryRepository.save(priceHistory);
    }
}
