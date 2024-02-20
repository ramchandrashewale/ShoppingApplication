package com.Rating.demo.controller;

import com.Rating.demo.dto.AggrigatedRating;
import com.Rating.demo.dto.RequstRating;
import com.Rating.demo.dto.Review;
import com.Rating.demo.entity.Rating;
import com.Rating.demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    //add rating
    @PostMapping("/post")
    public ResponseEntity<String> addrating(@RequestBody RequstRating requstRating){
      String response=  ratingService.addRating(requstRating);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    //to get review of user by userId
    @GetMapping("/user")
    public List<Rating> getUserRating(@RequestParam(value = "userId") int userId){
        return ratingService.getUserRating(userId);
    }

    //get aggrigated rating with production id
    @GetMapping
            ("/{productId}")
    public AggrigatedRating getAggregatedrating(@PathVariable int productId){
        return ratingService.getAggrigatedRating(productId) ;
    }


    //To find review list
    @GetMapping("/review")
    public Page<Rating> getAllReviews(@RequestParam(value = "productId")int productId,
                                      @RequestParam(value = "pageNo",required = false,defaultValue = "0")int pageNo,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize){
        return ratingService.getReviews(productId,pageNo,pageSize);
    }



}
