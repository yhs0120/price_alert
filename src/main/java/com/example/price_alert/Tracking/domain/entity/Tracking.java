package com.example.price_alert.Tracking.domain.entity;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.User.domain.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long target_price;

    @Builder
    public Tracking(User user, Product product, Long target_price) {
        this.user = user;
        this.product = product;
        this.target_price = target_price;
    }
}
