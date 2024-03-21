package com.sd3.market.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public record ProductRequestDto(
        @NotBlank String name,
        @Positive Double price
) {}