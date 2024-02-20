package com.Product.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue
    private Integer productId;

    private String productName;

    private String productDescription;

    private Double price;

    private int quantity;

    private String userName;

//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private List<ProductImage> productImages=new ArrayList<>();

}
