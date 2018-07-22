package com.rapidrepair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView title;
    private TextView description;
    private TextView host;
    private TextView numRatings;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        title =  findViewById(R.id.title);
        description =  findViewById(R.id.description);
        host =  findViewById(R.id.host);
        numRatings =  findViewById(R.id.numRatings);
        photo =  findViewById(R.id.photo);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Create some fake data
        ServiceReview r1 = new ServiceReview(4.5, "Best plumber in town!", "Bill Gates");
        ServiceReview r2 = new ServiceReview(5, "Excellent service", "Elon Musk");
        ServiceReview r3 = new ServiceReview(5, "Great job!", "Barack Obama");
        ServiceReview[] reviews = {r1, r2, r3};
        ArrayList<ServiceReview> s1_r = new ArrayList<>();
        s1_r.add(r1);
        s1_r.add(r2);
        s1_r.add(r3);
        ServicePost service = new ServicePost("Professional Plumber","I can help you with plumbing needs in the kitchen, bathroom, and basement", "Behar Hyseni", "/image/plumber.jpg",s1_r);

        title.setText(service.getTitle());
        description.setText(service.getDescription());
        host.setText(service.getHost());
        numRatings.setText(service.getNumRatings().toString());

        // specify an adapter (see also next example)
        mAdapter = new ReviewsAdapter(reviews, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
