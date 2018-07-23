package com.rapidrepair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class usertype extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;

    public usertype() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertype);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.question1);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                String amTech = "I am a technician.";
                String needTech = "I need a technician.";
                if (radioButton.getText().equals(needTech)) {
                    startActivity(new Intent(usertype.this, SearchActivity.class));
                } else if (radioButton.getText().equals(amTech)) {
                    startActivity(new Intent(usertype.this, ProviderFeed.class));
                } else {


                    Toast.makeText(usertype.this,
                            radioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
