package com.example.amynashamy.electionpoll;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.sql.SQLException;

/**
 * Created by amynashAmy on 04/03/16.
 */
public class StatPage extends AppCompatActivity {

    TextView results;
    MyDBManager db;
    LinearLayout container;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        container = (LinearLayout) findViewById(R.id.database);
        results = (TextView) findViewById(R.id.results);

        db = new MyDBManager(this);

        //// Do Database Lookup

       try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getRows();

        db.close();
    }


    //---get all tasks---
    public void getRows() {
        Cursor c = db.getAllPolled();
        //Cursor c = db.getAllTask();
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
                "Poll Choice: " + c.getString(1) + "\n" +
                "Poll Gender: " + c.getString(2) + "\n" +
                "Poll Has_Children: " + c.getString(3) + "\n" +
                "Poll Marital Status: " + c.getString(4) + "\n" +
                "Poll First_Time_Voter: " + c.getString(5) + "\n" +
                "Poll Party_Member: " + c.getString(6) + "\n" +
                "Poll Age: " + c.getString(7) + "\n" +
                "Poll Employment: " + c.getString(8) + "\n" +
                "Poll Income: " + c.getString(9) + "\n" +
                "Poll Reason_for_Candidate: " + c.getString(10) + "\n" +
                "Poll Locality: " + c.getString(11) + "\n");

        container.addView(text);

    }

}