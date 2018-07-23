package com.rapidrepair;

public class ServiceReview {
    // Person reviewer
    private double rating;
    private String review;
    private String reviewer;

    ServiceReview(double rating, String review, String reviewer) {
        this.rating = rating;
        this.review = review;
        this.reviewer = reviewer;
    }

    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public String getReviewer() {
        return reviewer;
    }
}