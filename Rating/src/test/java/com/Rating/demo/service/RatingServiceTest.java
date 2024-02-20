package com.Rating.demo.service;

import com.Rating.demo.dto.RequstRating;
import com.Rating.demo.entity.Rating;
import com.Rating.demo.repository.RatingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RatingServiceTest {

    @InjectMocks
    public RatingService ratingService;

    @Mock
    public RatingRepository ratingRepository;

        @Test
        public void addRating(){
            RequstRating requstRating=new RequstRating();
            requstRating.setStars(5);
            requstRating.setRatingImage("I will set latter");
            requstRating.setRatingDescription("Nice product");
            requstRating.setUserId(1);
            requstRating.setOrderId(1);
            requstRating.setProductId(1);


        }
        @Test
        public void getUserRating(){
            Rating rating=new Rating();
            rating.setRatingImage("I will add Latter");
            rating.setRatingDescription("Nice");
            rating.setStars(4);
        }
}
