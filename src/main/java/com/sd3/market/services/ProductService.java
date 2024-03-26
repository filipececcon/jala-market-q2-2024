package com.sd3.market.services;

import com.sd3.market.dto.ProductDetailsResponseDto;
import com.sd3.market.dto.ProductRequestDto;
import com.sd3.market.dto.ProductResponseDto;
import com.sd3.market.entities.Product;
import com.sd3.market.factories.ProductFactory;
import com.sd3.market.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;


    public ProductResponseDto create(ProductRequestDto request){

        Product product = new Product();

        BeanUtils.copyProperties(request, product);

        Product result = repository.save(product);

        return new ProductResponseDto(result.getName(), result.getPrice(), result.getCreatedAt(), result.getUpdatedAt());
    }

    public ProductResponseDto getById(UUID id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return null;

        return new ProductResponseDto(result.get().getName(), result.get().getPrice(), result.get().getCreatedAt(), result.get().getUpdatedAt());
    }

    public List<ProductDetailsResponseDto> getAll(Pageable pageable){

        Page<Product> products = repository.findAll(pageable);

        List<ProductDetailsResponseDto> results = products
                .stream()
                .map(ProductFactory::CreateDetails)
                .collect(Collectors.toList());

        return results;
    }

    public ProductResponseDto update(ProductRequestDto dto, UUID id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return null;

        result.get().setName(dto.name());
        result.get().setPrice(dto.price());

        Product saved = repository.save(result.get());

        return new ProductResponseDto(saved.getName(), saved.getPrice(), saved.getCreatedAt(), saved.getUpdatedAt());
    }

    public boolean delete(UUID id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return false;

        repository.delete(result.get());

        return true;
    }

}
