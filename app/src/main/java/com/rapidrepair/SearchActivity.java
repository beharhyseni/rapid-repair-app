package com.rapidrepair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class SearchActivity  extends AppCompatActivity {
    private static final String[] SERVICES = new String[] {
            "Room Cleaning",
            "House Cleaning",
            "Carpet Cleaning",
            "Hardwood Cleaning",
            "Plumbing",
            "Kitchen Cleaning",
            "Garage Cleaning",
            "Garage Repair",
            "Door Repair",
            "Carpenter",
            "Bathroom Repair",
            "Bathtub Repair",
            "Sink Repair",
            "Shower Repair",
            "Toliet Repair",
            "Pool Cleaning",
            "Roof Cleaning",
            "Furniture Cleaning",
            "Yard Work",
            "Lawn Services",
            "Landscaping",
            "Fence Painting",
            "Fence Repair",
            "Gardening",
            "Stump Removal",
            "Shed Cleaning",
            "Landscaping",
            "Weed Removal",
            "Lawn Mowing",
            "Mobile Repair",
            "Computer Repair",
            "Gutter Repair",
            "Drain Repair",
            "Tree Removal"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        MultiAutoCompleteTextView textView = findViewById(R.id.query);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SERVICES);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}