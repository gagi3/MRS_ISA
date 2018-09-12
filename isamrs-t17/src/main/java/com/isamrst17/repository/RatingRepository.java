package com.isamrst17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isamrst17.model.Rating;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {


}
