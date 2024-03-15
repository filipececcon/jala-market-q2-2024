package com.sd3.market.controllers;

import com.sd3.market.dtos.ProductDto;
import com.sd3.market.entities.Product;
import com.sd3.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody ProductDto dto){

        Product prd = new Product();

        prd.setName(dto.Name);
        prd.setPrice(dto.Price);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(prd));

    }




}
