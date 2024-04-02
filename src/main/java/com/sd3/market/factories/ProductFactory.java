package com.sd3.market.factories;

import com.sd3.market.dto.ProductDetailsResponseDto;
import com.sd3.market.dto.ProductResponseDto;
import com.sd3.market.entities.Product;
import org.springframework.beans.BeanUtils;

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

    public static ProductResponseDto Create(Product product){

        ProductResponseDto dto = new ProductResponseDto();

        BeanUtils.copyProperties(product, dto);

        return dto;
    }
}