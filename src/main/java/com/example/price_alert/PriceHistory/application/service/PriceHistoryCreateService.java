package com.example.price_alert.PriceHistory.application.service;

import com.example.price_alert.PriceHistory.application.dto.request.PriceHistoryRequest;
import com.example.price_alert.PriceHistory.application.mapper.PriceHistoryMapper;
import com.example.price_alert.PriceHistory.domain.entity.PriceHistory;
import com.example.price_alert.PriceHistory.domain.service.PriceHistorySaveService;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.ProductShop.domain.service.ProductShopQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceHistoryCreateService {

    private final PriceHistorySaveService priceHistorySaveService;
    private final ProductShopQueryService productShopQueryService;

    public void createPriceHistory(PriceHistoryRequest.PriceHistoryCreateRequest priceHistoryCreateRequest) {
        Long productShopId = priceHistoryCreateRequest.getProductShopId();
        ProductShop productShop = productShopQueryService.findByProductShopId(productShopId);

        PriceHistory priceHistory = PriceHistoryMapper.mapToPriceHistory(priceHistoryCreateRequest, productShop);
        priceHistorySaveService.savePriceHistory(priceHistory);
    }
}
