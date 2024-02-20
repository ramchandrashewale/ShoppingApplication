package com.Rating.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.OptionalDouble;


@Data
@Builder
public class AggrigatedRating {
    private Double rating;

    private Long noOfRating;

    private Long noOfReview;
}
