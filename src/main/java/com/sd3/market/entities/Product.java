package com.sd3.market.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Entity
//@Table(name="TB_PRODUCTS")
@Document(collection = "tb_products")
public class Product extends NoRelationalEntity{

    //@Column(name = "NM_PRODUCT")
    @Field("nm_product")
    private String name;
    //@Column(name = "VL_PRICE")
    @Field("vl_price")
    private Double Price;

    public Product() {

    }

    public Product(String name, Double price) {
        this.name = name;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}