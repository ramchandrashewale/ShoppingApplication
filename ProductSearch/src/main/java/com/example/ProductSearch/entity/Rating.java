package com.example.ProductSearch.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rating {


    private int ratingId;

    private int stars;

    private String ratingDescription;


    private List<RatingImage> ratingImage=new ArrayList<>();

    private int productId;

    private int orderId;

    private int userId;
}
