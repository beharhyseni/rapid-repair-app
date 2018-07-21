package com.rapidrepair;

import java.util.ArrayList;

class ServicePost {
    private String title;
    private String description;
    private String host;
    private double rating;
    private Integer numRatings;
    private ArrayList<ServiceReview> reviews;

    ServicePost(String title, String description, String host, ArrayList<ServiceReview> reviews) {
        this.title = title;
        this.description = description;
        this.host = host;
        this.reviews = reviews;
        this.numRatings = reviews.size();
        this.rating = calculateRating();
    }

    private double calculateRating() {
        double sum = 0;
        for(ServiceReview r : reviews){
            sum += r.getRating();
        }
        double average = Math.round((sum/numRatings) * 2) / 2.0;
        return average;
    }
}