package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by amynashAmy on 03/03/16.
 */
public class AgeScreenActivity extends AppCompatActivity {


    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agescreen);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AgeScreenActivity.this, VoteAction.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (AgeScreenActivity.this, UnderAgeActivity.class);
                startActivity(intent);
            }
        });

    }
    protected void onPause() {
        super.onPause();
        finish();
    }
}
