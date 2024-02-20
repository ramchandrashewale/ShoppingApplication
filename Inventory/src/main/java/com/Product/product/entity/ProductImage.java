package com.Product.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImage {
    @Id
    @GeneratedValue
    private  int productImageId;
    private String url;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
