package com.example.ProductSearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@
AllArgsConstructor
@NoArgsConstructor
public class ProductRatingList {

    private String productId;


    private String productName;


    private String productDescription;


    private Float price;


    private Long quantity;


    private String userName;

    //private List<Product.Image> images;


    @Data

    @AllArgsConstructor
    public static class Image{
        private   String url;
    }

    AggrigatedRating aggrigatedRating;

}
