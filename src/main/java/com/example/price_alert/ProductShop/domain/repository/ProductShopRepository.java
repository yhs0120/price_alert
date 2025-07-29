package com.example.price_alert.ProductShop.domain.repository;

import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.Shop.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductShopRepository extends JpaRepository<ProductShop, Long> {
    // 1. 특정 상품(Product)이 판매되는 모든 판매처(ProductShop) 목록을 조회
    List<ProductShop> findByProduct(Product product);

    // 2. 특정 상품(Product)과 쇼핑몰(Shop) 조합으로 하나의 판매처(ProductShop)를 조회
    Optional<ProductShop> findByProductAndShop(Product product, Shop shop);
}
