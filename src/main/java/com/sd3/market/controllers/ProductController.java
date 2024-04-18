package com.sd3.market.controllers;

import com.sd3.market.dto.ProductDetailsResponseDto;
import com.sd3.market.dto.ProductRequestDto;
import com.sd3.market.dto.ProductResponseDto;
import com.sd3.market.entities.Product;
import com.sd3.market.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @PostMapping
    @Cacheable(value="product")
    public ResponseEntity<ProductResponseDto> create(@RequestBody @Valid ProductRequestDto dto){

        System.out.println("ENTROU NO METODO");

        ProductResponseDto response = service.create(dto);

        response.add(linkTo(methodOn(ProductController.class).get(response.getId())).withSelfRel());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Cacheable(value="product")
    public ResponseEntity<ProductResponseDto> get(@PathVariable(value = "id") String id){

        System.out.println("BUSCOU O PRODUTO: " + id);

        ProductResponseDto result = service.getById(id);

        if(result == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@PageableDefault(page = 0, size = 3) Pageable pageable){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAll(pageable));
    }

    @PutMapping("/{id}")
    @CachePut(value = "product")
    public ResponseEntity<ProductResponseDto> update(@PathVariable(value = "id") String id, @RequestBody @Valid ProductRequestDto dto){

        return ResponseEntity.status(HttpStatus.OK).body(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value="product", allEntries = true)
    public ResponseEntity<Product> delete(@PathVariable(value = "id") String id){

        if(service.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
