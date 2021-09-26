package com.blue.ground.InterviewApp.reviews;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController {

    private static Logger logger = LogManager.getLogger(ReviewsController.class);

    public static String SUCCESS = "SUCCESS";

    @Autowired
    ReviewsUseCase reviewUsecase;

    @PostMapping(value = "/postReview")
    public String postReview(@RequestBody PostReviewRequest postReviewRequest) {
        try {
            reviewUsecase.postReview(postReviewRequest.getUnits_id(), postReviewRequest.getScore(),
                    postReviewRequest.getComment());
        } catch (Exception e) {
            logger.error("Exception occurred on retrievePageUnits! Details: " + e.getMessage());
        }
        return SUCCESS;
    }


}
