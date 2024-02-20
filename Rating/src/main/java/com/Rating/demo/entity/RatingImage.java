package com.Rating.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RatingImage {
    @Id
    @GeneratedValue
    private int imageId;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "rating_id",nullable = false)
    @JsonIgnore
    private Rating rating;
}
