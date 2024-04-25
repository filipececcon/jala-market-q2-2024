package com.sd3.market.repositories;

import com.sd3.market.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//@Repository
//public interface ProductRepository extends JpaRepository<Product, UUID> {}

public interface ProductRepository extends MongoRepository<Product, ObjectId> {}