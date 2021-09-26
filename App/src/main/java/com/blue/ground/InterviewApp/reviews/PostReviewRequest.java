package com.blue.ground.InterviewApp.reviews;

import java.io.Serializable;

public class PostReviewRequest implements Serializable {

    private Long units_id;
    private Integer score;
    private String comment;

    public PostReviewRequest(Long units_id, Integer score, String comment) {
        this.units_id = units_id;
        this.score = score;
        this.comment = comment;
    }

    public Long getUnits_id() {
        return units_id;
    }

    public void setUnits_id(Long units_id) {
        this.units_id = units_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
