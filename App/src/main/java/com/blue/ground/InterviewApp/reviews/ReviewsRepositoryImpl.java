package com.blue.ground.InterviewApp.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "reviewsRepository")
public interface ReviewsRepositoryImpl extends JpaRepository<Review, Long> {

}
