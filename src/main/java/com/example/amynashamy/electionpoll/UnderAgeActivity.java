package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by amynashAmy on 04/03/16.
 */
public class UnderAgeActivity extends AppCompatActivity {

    Button button1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underage);

    button1 = (Button) findViewById(R.id.button1);
       button1.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
               Intent intent = new Intent(UnderAgeActivity.this, MainActivity.class);
               startActivity(intent);
           }
           });
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}