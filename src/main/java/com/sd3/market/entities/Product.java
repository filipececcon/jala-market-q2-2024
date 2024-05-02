package com.sd3.market.entities;

import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Entity
//@Table(name="TB_PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tb_products")
public class Product extends NoRelationalEntity{

    //@Column(name = "NM_PRODUCT")
    @Field("nm_product")
    private String name;

    //@Column(name = "VL_PRICE")
    @Field("vl_price")
    private Double Price;


}