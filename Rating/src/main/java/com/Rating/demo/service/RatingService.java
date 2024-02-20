package com.Rating.demo.service;

import com.Rating.demo.dto.*;
import com.Rating.demo.entity.Rating;
import com.Rating.demo.entity.RatingImage;
import com.Rating.demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    public String addRating(RequstRating requstRating){

        Rating rating=Rating.builder()
                .stars(requstRating.getStars())
                .ratingDescription(requstRating.getRatingDescription())
                .orderId(requstRating.getOrderId())
                .userId(requstRating.getUserId())
                .productId(requstRating.getProductId())
                .build();
            List<RatingImageRequest> list=requstRating.getRatingImage();
            if(list!=null){
                for(RatingImageRequest url:list){
                    RatingImage ratingImage=new RatingImage();
                    ratingImage.setImageUrl(url.getImageUrl());
                    ratingImage.setRating(rating);
                    rating.getRatingImage().add(ratingImage);
                }
            }

            ratingRepository.save(rating);
            return "Thanks For giving rating";
    }
        public String updateRating(int reviewId, RatingUpdate ratingUpdate){
            Optional<Rating> givenRating=ratingRepository.findByRatingId(reviewId);

            if(givenRating.isPresent()){
                Rating existing=givenRating.get();
                if(ratingUpdate.getRatingDescription()!=null){
                        existing.setRatingDescription(ratingUpdate.getRatingDescription());
                }
                if(ratingUpdate.getStars() !=null){
                    existing.setStars(ratingUpdate.getStars());
                }

                ratingRepository.save(existing);
            }

            return "Sucesfully Updated";
        }
    public List<Rating> getUserRating(int userId){
        List<Rating> ratingList=ratingRepository.findByUserId(userId);
        return ratingList;
    }

    public AggrigatedRating getAggrigatedRating(int productId){


        //Select productId avg(rating) from rating
      Double averageRating=  ratingRepository.findAverageRatingByProductId(productId);

      //no of rating
      Long noOfRating =  ratingRepository.countByProductId(productId);


      //no of review;
      Long noOfReviews=ratingRepository.countReviewsWithDescriptionAndImagesByProductId(productId);


        //select count(productId) from rating where imageID and description is empty
        AggrigatedRating aggrigatedRating=AggrigatedRating.builder()
                .noOfRating(noOfRating)
                .rating(averageRating)
                .noOfReview(noOfReviews)
                .build();

        return aggrigatedRating;

    }

    public Page<Rating> getReviews(int productId, int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo, pageSize);

        Page<Rating> ratingPage = ratingRepository.findByProductIdAndRatingDescriptionIsNotNullAndRatingImageIsNotNull(productId, pageable);
        System.out.println(ratingPage.getContent());
        return ratingPage;
    }

}
