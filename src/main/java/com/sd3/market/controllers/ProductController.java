package com.sd3.market.controllers;

import com.sd3.market.dtos.ProductDto;
import com.sd3.market.entities.Product;
import com.sd3.market.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid ProductDto dto){

        Product prd = new Product();

        prd.setName(dto.name());
        prd.setPrice(dto.price());

        Product result = repository.save(prd);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable(value = "id") UUID id){

        Optional<Product> result =  repository.findById(id);

        if(result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){

        List<Product> results =  repository.findAll();

       //if(results.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(results);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable(value = "id") UUID id, @RequestBody ProductDto dto){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        result.get().setName(dto.name());
        result.get().setPrice(dto.price());

        repository.save(result.get());

        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entity> delete(@PathVariable(value = "id") UUID id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        repository.delete(result.get());

        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

}
