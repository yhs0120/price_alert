package com.example.price_alert.PriceHistory.domain.entity;

import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_shop_id")
    private ProductShop productShop;

    private Long price;

    @Enumerated(EnumType.STRING) // Enum 타입을 DB에 저장할 때 문자열로 저장
    private StockStatus stockStatus;

    @CreatedDate // 엔티티 생성 시 시간 자동 저장
    @Column(updatable = false)
    private LocalDateTime recordedAt; // 기록 시간 필드 추가

    @Builder
    public PriceHistory(ProductShop productShop, Long price, StockStatus stockStatus, LocalDateTime recordedAt) {
        this.productShop = productShop;
        this.price = price;
        this.stockStatus = stockStatus;
        this.recordedAt = recordedAt;
    }
}
