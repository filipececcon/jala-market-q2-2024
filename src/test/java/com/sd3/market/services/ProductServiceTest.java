package com.sd3.market.services;

import com.sd3.market.dto.ProductRequestDto;
import com.sd3.market.entities.Product;
import com.sd3.market.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.*;

@SpringBootTest
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @Autowired
    @InjectMocks
    private ProductService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Should thrown exception when product name is already exists")
    void createAlreadyExists() {

        var dto = new ProductRequestDto("MELANCIA", 10.0);

        when(repository.findByName("MELANCIA")).thenReturn(new Product("MELANCIA", 10.0));

        try {

            var result = service.create(dto);

        } catch (Exception ex){

            verify(repository, times(1)).findByName("MELANCIA");

            Assertions.assertEquals(ex.getMessage(), "O produto já existe");
        }
    }
    @Test
    void create() throws Exception{
        var dto = new ProductRequestDto("BATATA", 4.0);

        var product = new Product(dto.name(), dto.price());

        when(repository.insert(any(Product.class))).thenReturn(product);

        var result = service.create(dto);

        Assertions.assertNotNull(result.getId());
    }


}