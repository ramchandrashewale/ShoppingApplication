package com.example.ProductSearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class RatingImage {

    private int imageId;
    private String imageUrl;


    @JsonIgnore
    private Rating rating;
}
