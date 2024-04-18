package com.sd3.market.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Entity
//@Table(name="TB_PRODUCTS")
@Document(collection = "tb_products")
public class Product extends NoRelationalEntity{

    //@Column(name = "NM_PRODUCT")
    @Field("nm_product")
    private String Name;
    //@Column(name = "VL_PRICE")
    @Field("vl_price")
    private Double Price;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}