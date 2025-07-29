package com.example.price_alert.PriceHistory.presentation;

import com.example.price_alert.PriceHistory.application.dto.request.PriceHistoryRequest;
import com.example.price_alert.PriceHistory.application.dto.response.PriceHistoryResponse.PriceHistoryInfoResponse;
import com.example.price_alert.PriceHistory.application.service.PriceHistoryCreateService;
import com.example.price_alert.PriceHistory.application.service.PriceHistoryGetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/price-history")
public class PriceHistoryController {

    private final PriceHistoryCreateService priceHistoryCreateService;
    private final PriceHistoryGetService priceHistoryGetService;

    /**
     * 새로운 가격 이력 등록 API
     */
    @PostMapping
    public ResponseEntity<Void> createPriceHistory(@Valid @RequestBody PriceHistoryRequest.PriceHistoryCreateRequest request) {
        priceHistoryCreateService.createPriceHistory(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 특정 판매처의 모든 가격 이력 조회 API
     * 예: /api/price-history?productShopId=1
     */
    @GetMapping
    public ResponseEntity<List<PriceHistoryInfoResponse>> getAllPriceHistory(@RequestParam Long productShopId) {
        List<PriceHistoryInfoResponse> historyList = priceHistoryGetService.getAllPriceHistoryForProductShop(productShopId);
        return ResponseEntity.ok(historyList);
    }

    /**
     * 특정 판매처의 가장 최신 가격 정보 조회 API
     * 예: /api/price-history/latest?productShopId=1
     */
    @GetMapping("/latest")
    public ResponseEntity<PriceHistoryInfoResponse> getLatestPriceHistory(@RequestParam Long productShopId) {
        PriceHistoryInfoResponse latestPrice = priceHistoryGetService.getLatestPriceForProductShop(productShopId);
        return ResponseEntity.ok(latestPrice);
    }
}