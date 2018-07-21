package com.rapidrepair;

public class ServiceReview {
    // Person reviewer
    private double rating;
    private String review;

    ServiceReview(double rating, String review){
        this.rating = rating;
        this.review = review;
    }

    public double getRating(){
        return rating;
    }

    public String getReview(){
        return review;
    }
}
