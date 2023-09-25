package com.example.stage4e.Repository;

import com.example.stage4e.Entities.Product;
import com.example.stage4e.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    @Query("SELECT COUNT(r) FROM Rating r WHERE r.product = :product")
    Integer countRatingsByProduct(@Param("product") Product product);
}
