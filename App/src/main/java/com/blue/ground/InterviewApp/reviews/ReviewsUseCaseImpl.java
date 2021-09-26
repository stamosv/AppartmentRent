package com.blue.ground.InterviewApp.reviews;

import com.blue.ground.InterviewApp.units.Unit;
import com.blue.ground.InterviewApp.units.UnitsRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service(value = "reviewsUseCase")
public class ReviewsUseCaseImpl implements ReviewsUseCase {

    private static Logger logger = LogManager.getLogger(ReviewsUseCaseImpl.class);

    @Autowired
    private UnitsRepositoryImpl unitsRepository;

    @Autowired
    private ReviewsRepositoryImpl reviewsRepositoryImpl;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void postReview(Long units_id, Integer score, String comment) {
        try {
            Unit unit = unitsRepository.getOne(units_id);
            unit = setUnitNewTotalScore(unit, score);

            Review review = new Review(comment, score, unit);
            reviewsRepositoryImpl.save(review);
            reviewsRepositoryImpl.flush();

            logger.info("Review-List after save: " + reviewsRepositoryImpl.findAll());

        } catch (Exception e) {
            logger.error("Exception occurred on retrievePageUnits! Details: " + e.getMessage());
        }
    }

    private Unit setUnitNewTotalScore(Unit unit, Integer score) {
        Set<Review> unitReviews = unit.getReviews();

        if (unitReviews != null) {
            Double totalScore = score.doubleValue();
            for (Review unitReview : unitReviews) {
                totalScore = totalScore + unitReview.getScore();
            }
            unit.setScore(totalScore / (unitReviews.size() + 1));
        }
        return unit;
    }

}
