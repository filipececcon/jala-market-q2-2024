package com.sd3.market.factories;

import com.sd3.market.dto.ProductDetailsResponseDto;
import com.sd3.market.entities.Product;

public class ProductFactory {
    public static ProductDetailsResponseDto CreateDetails(Product product){
        return new ProductDetailsResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
