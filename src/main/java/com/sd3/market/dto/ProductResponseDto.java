package com.sd3.market.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ProductResponseDto(String name, Double price, LocalDateTime updateAt) implements Serializable {
}
