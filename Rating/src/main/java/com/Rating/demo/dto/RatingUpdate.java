package com.Rating.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingUpdate {
    private Integer stars;

    private String ratingDescription;

    private String ratingImage;
}
