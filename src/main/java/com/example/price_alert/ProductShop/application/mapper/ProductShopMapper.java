package com.example.price_alert.ProductShop.application.mapper;

import com.example.price_alert.Product.application.dto.response.ProductResponse;
import com.example.price_alert.Product.application.mapper.ProductMapper;
import com.example.price_alert.Product.domain.entity.Product;
import com.example.price_alert.ProductShop.application.dto.request.ProductShopRequest;
import com.example.price_alert.ProductShop.application.dto.response.ProductShopResponse;
import com.example.price_alert.ProductShop.domain.entity.ProductShop;
import com.example.price_alert.Shop.application.dto.response.ShopResponse;
import com.example.price_alert.Shop.application.mapper.ShopMapper;
import com.example.price_alert.Shop.domain.entity.Shop;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductShopMapper {

    public static ProductShop mapToProductShop(ProductShopRequest.ProductShopCreateRequest productShopCreateRequest, Product product, Shop shop) {
        return ProductShop.builder()
                .product(product)
                .shop(shop)
                .build();
    }


    public static ProductShopResponse.ProductShopInfoResponse mapToProductShopInfoResponse(ProductShop productShop) {
        ProductResponse.SimpleProductInfo simpleProductInfo = ProductMapper.mapToProductSimpleProductInfo(productShop.getProduct());
        ShopResponse.ShopInfoResponse shopInfoResponse = ShopMapper.mapToShopResponse(productShop.getShop());

        return ProductShopResponse.ProductShopInfoResponse.builder()
                .productShopId(productShop.getProduct_shop_id())
                .product(simpleProductInfo)
                .shop(shopInfoResponse)
                .build();
    }
}
