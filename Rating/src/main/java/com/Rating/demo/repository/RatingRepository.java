package com.Rating.demo.repository;

import com.Rating.demo.entity.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findByProductId(int productId);
  
    //indexing on two columns of user and productid
    List<Rating> findByUserId(int userId);



    Page<Rating> findByProductIdAndRatingDescriptionIsNotNullAndRatingImageIsNotNull(int productId, PageRequest pageable);

    Optional<Rating> findByRatingId(int reviewId);



    //@Query("SELECT AVG(r.stars) FROM Rating r WHERE r.product.id = :productId")
    @Query("SELECT AVG(r.stars) FROM Rating r WHERE r.productId = :productId")

    Double findAverageRatingByProductId(@Param("productId") int productId);


    Long countByProductId(int productId);


    @Query("SELECT COUNT(*) FROM Rating r JOIN r.ratingImage ri " +
            "WHERE r.ratingDescription IS NOT NULL AND ri.imageUrl IS NOT NULL AND r.productId = :productId")
    Long countReviewsWithDescriptionAndImagesByProductId(@Param("productId") int productId);


}
