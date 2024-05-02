package com.sd3.market.repositories;

import com.sd3.market.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Should save a product on database")
    public void createProduct(){

        //Arrange
        var name = "MELANCIA";

        var product = new Product(name, 10.0);

        //Act
        var saved = productRepository.insert(product);

        //Assert
        Assertions.assertEquals(saved.getName(), name);
    }


}