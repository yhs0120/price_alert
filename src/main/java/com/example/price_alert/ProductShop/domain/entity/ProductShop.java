package com.example.price_alert.ProductShop.domain.entity;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.Shop.domain.entity.Shop;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class ProductShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_shop_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Builder
    public ProductShop(Product product, Shop shop) {
        this.product = product;
        this.shop = shop;
    }
}
