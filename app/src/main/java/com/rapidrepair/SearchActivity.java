package com.rapidrepair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    private static Button srchButton;
    private static View view;

    public SearchActivity() {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        addListenerOnButton();
    }
    public void addListenerOnButton() {

        srchButton = (Button) findViewById(R.id.searchButton);

        srchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (true) {
                    startActivity(new Intent(SearchActivity.this, FeedActivity.class));


                }
            }
        });


    }}
