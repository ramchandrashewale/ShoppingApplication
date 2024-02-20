package com.Rating.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequstRating {
    private int stars;

    private String ratingDescription;

    private List<RatingImageRequest> ratingImage;

    private int productId;

    private int orderId;

    private int userId;
}
