package com.Rating.demo.dto;

import com.Rating.demo.entity.RatingImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Review {
    private int stars;

    private String ratingDescription;

    private List<RatingImage> ratingImage;

    private int userId;
}
