package com.sd3.market.services;

import com.sd3.market.dto.ProductRequestDto;
import com.sd3.market.dto.CreateProductResponseDto;
import com.sd3.market.dto.ProductResponseDto;
import com.sd3.market.entities.Product;
import com.sd3.market.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;


    public CreateProductResponseDto create(ProductRequestDto request){

        Product product = new Product();

        BeanUtils.copyProperties(request, product);

        Product result = repository.save(product);

        return new CreateProductResponseDto(result.getName(), result.getPrice(), result.getCreatedAt());
    }

    public ProductResponseDto getById(UUID id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return null;

        return new ProductResponseDto(result.get().getName(), result.get().getPrice(), result.get().getUpdatedAt());

    }

    public List<ProductResponseDto> getAll(){

        List<Product> products = repository.findAll();

        List<ProductResponseDto> results = products
                .stream()
                .map(product -> new ProductResponseDto(product.getName(), product.getPrice(), product.getUpdatedAt()))
                .collect(Collectors.toList());

        return results;

    }



}
