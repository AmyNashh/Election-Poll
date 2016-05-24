package com.example.amynashamy.electionpoll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.database.Cursor;
import java.lang.*;
import java.sql.SQLException;



/**
 * Created by amynashAmy on 21/03/16.
 */
public class StatCalculations extends AppCompatActivity {

    TextView results;
    MyDBManager db;
    LinearLayout container;
    String gender;
    String age;
    String locality;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statcalculations);

        container = (LinearLayout) findViewById(R.id.database);
        results = (TextView) findViewById(R.id.results);
        db = new MyDBManager(this); //initialize the database
        Bundle bundle = getIntent().getExtras(); //get the gender, age and location choices the user chose
        gender = (bundle.getString("gender"));
        age = (bundle.getString("age"));
        locality = (bundle.getString("locality"));


        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ////// all ifs for all options that the users can click in the 3 spinners////
        if (gender.equals("All") && age.equals("All") && locality.equals("All")) {
            getRows();
        }
        if (gender.equals("All") && age.equals("All") && !locality.equals("All")) {
            getgenderage(locality);
        }
        if (!gender.equals("All") && age.equals("All") && locality.equals("All")) {
            getAllAgeLoc(gender);
        }
        if (gender.equals("All") && !age.equals("All") && locality.equals("All")) {
            getAllGenderLoc(age);
        }
        if (!gender.equals("All") && !age.equals("All") && locality.equals("All")) {
            getAllLoc(gender, age);
        }
        if (!gender.equals("All") && age.equals("All") && !locality.equals("All")) {
            getAllAge(gender, locality);
        }
        if (gender.equals("All") && !age.equals("All") && !locality.equals("All")) {
            getAllGender(age, locality);


        } else {
            getAverage();//get all gender, age and locality

        }

        db.close();
    }

//////
    public void getRows() {
        Cursor c = db.getAllPolled();
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }
/////
    public void getAverage(){
        Cursor c = db.getAverage(gender, age, locality);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }
///////
    public void getgenderage(String locality) {
        Cursor c = db.getgenderage(locality);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }

///////

    public void getAllAgeLoc(String gender) {
        Cursor c = db.getAllAgeLoc(gender);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }
    ///////
    public void getAllGenderLoc(String age) {
        Cursor c = db.getAllAgeLoc(age);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }

    ////////
    public void getAllLoc(String gender, String age) {
        Cursor c = db.getAllLoc(gender, age);

        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }
    ////////
    public void getAllAge(String gender, String locality) {
        Cursor c = db.getAllAge(gender, locality);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }

    ///////

    public void getAllGender(String age, String locality) {
        Cursor c = db.getAllGender(age, locality);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }


    public void ShowTask(Cursor c) {

        TextView text = new TextView(this);

        results.append("\n" +
                "Poll id: " + c.getString(0) + "\n" +
                "Poll Choice: " + c.getString(1) + " votes= " + c.getCount() + "\n" +
                "Poll Gender: " + c.getString(2) + "\n" +
                "Poll Has_Children: " + c.getString(3) + "\n" +
                "Poll Marital Status: " + c.getString(4) + "\n" +
                "Poll First_Time_Voter: " + c.getString(5) + "\n" +
                "Poll Party_Member: " + c.getString(6) + "\n" +
                "Poll Age: " + c.getString(7) + "\n" +
                "Poll Employment: " + c.getString(8) + "\n" +
                "Poll Income: " + c.getString(9) + "\n" +
                "Poll Reason_for_Candidate: " + c.getString(10) + "\n" +
                "Poll Locality: " + c.getString(11) + "\n" + "\n"
        );



        container.addView(text);

    }
}
