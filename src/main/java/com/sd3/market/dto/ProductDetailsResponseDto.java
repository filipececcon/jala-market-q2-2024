package com.sd3.market.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDetailsResponseDto(
        String id,
        String name,
        Double price,
        LocalDateTime createdAt,
        LocalDateTime updateAt

) implements Serializable {
}
