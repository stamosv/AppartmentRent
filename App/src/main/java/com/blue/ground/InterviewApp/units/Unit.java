package com.blue.ground.InterviewApp.units;

import com.blue.ground.InterviewApp.reviews.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "UNITS")
public class Unit implements java.io.Serializable {

    @Id
    @SequenceGenerator(name = "UNITS_SEQ", sequenceName = "UNITS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNITS_SEQ")
    @Column(name = "ID", unique = true, nullable = false, length = 10)
    private Long id;

    @Column(name = "IMAGE", nullable = false, length = 250)
    private String image;

    @Column(name = "TITLE", nullable = false, length = 250)
    private String title;

    @Column(name = "REGION", nullable = false, length = 250)
    private String region;

    @Column(name = "DESCRIPTION", nullable = false, length = 250)
    private String description;

    @Column(name = "CANCELLATION_POLICY", nullable = false, precision = 1, scale = 0)
    private Boolean cancellationPolicy;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "SCORE", nullable = false)
    private Double score;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "unit", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();

    public Unit(){

    }

    public Unit(String image, String title, String region, String description, Boolean cancellationPolicy, Double price, Double score) {
        this.image = image;
        this.title = title;
        this.region = region;
        this.description = description;
        this.cancellationPolicy = cancellationPolicy;
        this.price = price;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(Boolean cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(id, unit.id) &&
                Objects.equals(image, unit.image) &&
                Objects.equals(title, unit.title) &&
                Objects.equals(region, unit.region) &&
                Objects.equals(description, unit.description) &&
                Objects.equals(cancellationPolicy, unit.cancellationPolicy) &&
                Objects.equals(price, unit.price) &&
                Objects.equals(score, unit.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, title, region, description, cancellationPolicy, price, score);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", cancelationPolicy=" + cancellationPolicy +
                ", price=" + price +
                ", score=" + score +
                '}';
    }
}
