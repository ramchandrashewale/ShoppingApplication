package com.example.ProductSearch.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AggrigatedRating {
    private Double rating;

    private Long noOfRating;

    private Long noOfReview;
}
