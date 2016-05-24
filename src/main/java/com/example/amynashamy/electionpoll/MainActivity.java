package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;//declare unique names each of the buttons
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//on creation of this page
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//referencing the xml design of the page


        button1 = (Button) findViewById(R.id.button1);//find the button with this id in the context of activity_main
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {//on click of this button start the intent of going from this mainactivity to age screen activity
                Intent intent1 = new Intent(MainActivity.this, AgeScreenActivity.class);
                startActivity(intent1);

            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, StatOption.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}