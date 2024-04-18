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

        return ProductFactory.Create(repository.save(product));
    }

    public ProductResponseDto getById(String id){

        Optional<Product> result = repository.findById(id);

        return result.isEmpty() ? null : ProductFactory.Create(result.get());
    }

    public Page<Product> getAll(Pageable pageable){

        Page<Product> products = repository.findAll(pageable);



//        List<ProductDetailsResponseDto> results = products
//                .stream()
//                .map(ProductFactory::CreateDetails)
//                .collect(Collectors.toList());

        return products;
    }

    public ProductResponseDto update(ProductRequestDto dto, String id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return null;

        Product toUpdate = result.get();

        toUpdate.setName(dto.name());
        toUpdate.setPrice(dto.price());

        Product saved = repository.save(toUpdate);

        return ProductFactory.Create(saved);
    }

    public boolean delete(String id){

        Optional<Product> result = repository.findById(id);

        if(result.isEmpty()) return false;

        repository.deleteById(id);

        return true;
    }

}
