package com.Product.product.dto;

import com.Product.product.entity.ProductImage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ProductRequest {
    private String productName;

    private String productDescription;

    private Double price;

    private int quantity;

    private String userName;

    //private List<ProductImage> productImages=new ArrayList<>();
}
