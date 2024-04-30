package com.sd3.market.services;

import com.sd3.market.dto.ProductRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    void create() {

        var dto = new ProductRequestDto("MELANCIA", 10.0);

        try {

            var result = service.create(dto);

        } catch (Exception ex){

            Assertions.assertEquals(ex.getMessage(), "O produto já existe");
        }

    }
}