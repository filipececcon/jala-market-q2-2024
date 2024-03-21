package com.sd3.market.controllers;

import com.sd3.market.dto.ProductRequestDto;
import com.sd3.market.dto.CreateProductResponseDto;
import com.sd3.market.dto.ProductResponseDto;
import com.sd3.market.repositories.ProductRepository;
import com.sd3.market.entities.Product;
import com.sd3.market.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @Autowired
    private ProductRepository repository;


    @PostMapping
    public ResponseEntity<CreateProductResponseDto> create(@RequestBody @Valid ProductRequestDto dto){

        CreateProductResponseDto response = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> get(@PathVariable(value = "id") UUID id){

        ProductResponseDto result = service.getById(id);

        if(result == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable(value = "id") UUID id, @RequestBody ProductRequestDto dto){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        result.get().setName(dto.name());
        result.get().setPrice(dto.price());

        repository.save(result.get());

        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable(value = "id") UUID id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        repository.delete(result.get());

        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

}
