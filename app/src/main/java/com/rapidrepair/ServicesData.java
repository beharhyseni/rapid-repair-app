package com.rapidrepair;

import java.util.ArrayList;

public class ServicesData {
    private ServicePost[] servicesData;

    ServicesData(){
        ServiceReview r1 = new ServiceReview(5, "Best plumber in town!", "Bill Gates");
        ServiceReview r2 = new ServiceReview(5, "Excellent service! My sink was fixed within 30 mins", "Elon Musk");
        ServiceReview r3 = new ServiceReview(4, "Great service but too expensive", "Barack Obama");
        ServiceReview r4 = new ServiceReview(4, "Great rates but too far from me!", "Bill Nye the Science Guy");
        ServiceReview r5 = new ServiceReview(3, "Decent if you want a job done in a hurry", "Justin Trudeau");
        ServiceReview r6 = new ServiceReview(4, "Great job!", "Beyonce");
        ServiceReview r7 = new ServiceReview(5, "Professional with great prices!", "Steve Jobs");
        ServiceReview r8 = new ServiceReview(4, "Replied within an hour of my request", "Grace Hopper");
        ServiceReview r9 = new ServiceReview(3, "Not bad, but too expensive", "Terry Fox");
        ServiceReview r10 = new ServiceReview(4, "Great service and great personality!", "Ryan Reynolds");
        ServiceReview r11 = new ServiceReview(5, "Hands done my favourite person to call for the job!", "Bryan Adams");
        ServiceReview r12 = new ServiceReview(4, "Awesome!", "Emma Watson");
        ArrayList<ServiceReview> s1_r = new ArrayList<>();
        ArrayList<ServiceReview> s2_r = new ArrayList<>();
        ArrayList<ServiceReview> s3_r = new ArrayList<>();
        ArrayList<ServiceReview> s4_r = new ArrayList<>();
        ArrayList<ServiceReview> s5_r = new ArrayList<>();
        s1_r.add(r1);
        s1_r.add(r2);
        s1_r.add(r3);
        s2_r.add(r4);
        s2_r.add(r5);
        s3_r.add(r6);
        s3_r.add(r7);
        s3_r.add(r8);
        s4_r.add(r9);
        s4_r.add(r10);
        s5_r.add(r11);
        s5_r.add(r12);
        ServicePost service1 = new ServicePost("Professional Plumbing","I can help you with plumbing needs in the kitchen, bathroom, and basement", "Behar Hyseni", "plumber.jpg",s1_r);
        ServicePost service2 = new ServicePost("Landscaping","Stump removal, weed removal", "Cathy Jiao", "/images/landscaping.jpg", s2_r);
        ServicePost service3 = new ServicePost("Computer Repair","Windows, Mac ... I'll fix it for you at a great price", "James Cordon", "/images/landscaping.jpg", s2_r);
        ServicePost service4 = new ServicePost("Gutter Cleaning","Quick and clean gutters! You rest while I clean.", "Camila Cabello", "/images/landscaping.jpg", s2_r);
        ServicePost service5 = new ServicePost("Carpet Cleaning","Got dirty carpets? Stains? Contact me!", "Joyce Liu", "/images/landscaping.jpg", s2_r);

        servicesData = new ServicePost[]{service1, service2, service3, service4, service5};
    }

    public ServicePost[] getServicesData() {
        return servicesData;
    }
}