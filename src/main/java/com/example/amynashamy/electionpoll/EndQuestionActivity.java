package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.sql.SQLException;

/**
 * Created by amynashAmy on 08/03/16.
 */
public class EndQuestionActivity extends AppCompatActivity {

    MyDBManager db;
    Button button1;

    private String  itemvalue;
    private String  radio_string1;
    private String  radio_string2;
    private String  radio_string3;
    private String  radio_string4;
    private String  radio_string5;
    private String  spinner_string1;
    private String  spinner_string2;
    private String  spinner_string3;
    private String  spinner_string4;
    private String  spinner_string5;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endquestions);

        db = new MyDBManager(this);
        Bundle bundle = getIntent().getExtras();

        itemvalue = (bundle.getString("text0"));
        radio_string1 = (bundle.getString("text1"));
        radio_string2 = (bundle.getString("text2"));
        radio_string3 = (bundle.getString("text3"));
        radio_string4 = (bundle.getString("text4"));
        radio_string5 = (bundle.getString("text5"));
        spinner_string1 = (bundle.getString("text6"));
        spinner_string2 = (bundle.getString("text7"));
        spinner_string3 = (bundle.getString("text8"));
        spinner_string4 = (bundle.getString("text9"));
        spinner_string5 = (bundle.getString("text10"));



        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        db.open();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    db.insertPoll(itemvalue, radio_string1, radio_string2, radio_string3, radio_string4,
                            radio_string5, spinner_string1, spinner_string2, spinner_string3,
                            spinner_string4, spinner_string5);

                    db.close();

                    Intent intent = new Intent(EndQuestionActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

    }
