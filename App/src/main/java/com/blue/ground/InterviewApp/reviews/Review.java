package com.blue.ground.InterviewApp.reviews;

import com.blue.ground.InterviewApp.units.Unit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @SequenceGenerator(name = "REVIEWS_SEQ", sequenceName = "REVIEWS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEWS_SEQ")
    @Column(name = "ID", unique = true, nullable = false, length = 10)
    private Long id;

    @Column(name = "COMMENT", nullable = false, length = 250)
    private String comment;

    @Column(name = "SCORE", nullable = false)
    private Integer score;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "units_id")
    private Unit unit;

    public Review(String comment, Integer score, Unit unit) {
        this.comment = comment;
        this.score = score;
        this.unit = unit;
    }

    public Review() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", score='" + score + '\'' +
                ", unit=" + unit +
                '}';
    }
}
