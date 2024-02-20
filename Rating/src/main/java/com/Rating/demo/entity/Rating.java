package com.Rating.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rating {

    @Id
    @GeneratedValue
    private int ratingId;

    private int stars;

    private String ratingDescription;

    @OneToMany(mappedBy = "rating", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingImage> ratingImage=new ArrayList<>();

    private int productId;

    private int orderId;

    private int userId;
}
