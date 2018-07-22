package com.rapidrepair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.rapidrepair.R;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Create some fake data
        ServiceReview r1 = new ServiceReview(4.5, "Best plumber in town!");
        ServiceReview r2 = new ServiceReview(5, "Excellent service");
        ServiceReview r3 = new ServiceReview(5, "Great job!");
        ArrayList<ServiceReview> s1_r = new ArrayList<>();
        ArrayList<ServiceReview> s2_r = new ArrayList<>();
        s1_r.add(r1);
        s1_r.add(r2);
        s2_r.add(r3);
        ServicePost service1 = new ServicePost("Professional Plumber","I can help you with plumbing needs in the kitchen, bathroom, and basement", "Behar Hyseni", "/image/plumber.jpg",s1_r);
        ServicePost service2 = new ServicePost("Landscaper","Stump removal, weed removal", "Cathy Jiao", "/images/landscaping.jpg", s2_r);
        ServicePost[] posts = {service1, service2};

        // specify an adapter (see also next example)
        mAdapter = new PostsAdapter(posts, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}