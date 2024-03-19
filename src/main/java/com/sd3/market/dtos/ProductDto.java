package com.sd3.market.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductDto(@NotBlank String name, @Positive Double price) {

}
