package com.sd3.market.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record CreateProductResponseDto(String name, Double price, LocalDateTime createdAt) implements Serializable {
}
