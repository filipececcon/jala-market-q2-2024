package com.sd3.market.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_PRODUCTS")
public class Product extends AbstractEntity{

    @Column(name = "NM_PRODUCT")
    private String Name;
    @Column(name = "VL_PRICE")
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