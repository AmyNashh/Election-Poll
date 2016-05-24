package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.LinearLayout;

import java.sql.SQLException;

/**
 * Created by amynashAmy on 22/03/16.
 */
public class CandidateCount extends AppCompatActivity {

    private MyDBManager db;
    LinearLayout container;
    TextView results;

    String A = "Fidelma Healy Eames";
    String B ="Noel Grealish";
    String C = "Mary Hoade";
    String D = "John Connolly";
    String E = "Derek Nolan";
    String F = "Niall O'Thuathail";
    String G = "Hildegarde Naughton";
    String H = "Sean Kyne";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidatelist2);

        results = (TextView) findViewById(R.id.results);
        container = (LinearLayout) findViewById(R.id.database);
        db = new MyDBManager(this);
        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getA();
        getB();
        getC();
        getD();
        getE();
        getF();
        getG();
        getH();
        db.close();
    }

    public void getA() {
        Cursor c = db.getAllPolled();//get information from all polled
        int totalCount = c.getCount();//get the total count of everyone who voted
        Cursor c1 = db.getVotes(A);//get information for this candidate
        int Count = c1.getCount();//get the number of votes for that candidate
        int percentage = ( ( (int) Count* 100) / (int) totalCount);//divide the total number of votes by the number of votes this candidate received (multiply by 100)
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

                    container.addView(text);
        }
    }

    public void getB() {
        Cursor c = db.getAllPolled();
        int totalCount = c.getCount();
        Cursor c1 = db.getVotes(B);
        int Count = c1.getCount();
        int percentage = ( ( (int) Count* 100) / (int) totalCount);
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

            container.addView(text);
        }
    }
    public void getC() {
        Cursor c = db.getAllPolled();
        int totalCount = c.getCount();
        Cursor c1 = db.getVotes(C);
        int Count = c1.getCount();
        int percentage = ( ( (int) Count* 100) / (int) totalCount);
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

            container.addView(text);
        }
    }
    public void getD() {
        Cursor c = db.getAllPolled();
        int totalCount = c.getCount();
        Cursor c1 = db.getVotes(D);
        int Count = c1.getCount();
        int percentage = ( ( (int) Count* 100) / (int) totalCount);
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

            container.addView(text);
        }
    }
    public void getE() {
        Cursor c = db.getAllPolled();
        int totalCount = c.getCount();
        Cursor c1 = db.getVotes(E);
        int Count = c1.getCount();
        int percentage = ( ( (int) Count* 100) / (int) totalCount);
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

            container.addView(text);
        }
    }
    public void getF() {
        Cursor c = db.getAllPolled();
        int totalCount = c.getCount();
        Cursor c1 = db.getVotes(F);
        int Count = c1.getCount();
        int percentage = ( ( (int) Count* 100) / (int) totalCount);
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

            container.addView(text);
        }
    }
    public void getG() {
        Cursor c = db.getAllPolled();
        int totalCount = c.getCount();
        Cursor c1 = db.getVotes(G);
        int Count = c1.getCount();
        int percentage = ( ( (int) Count* 100) / (int) totalCount);
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

            container.addView(text);
        }
    }
    public void getH() {
        Cursor c = db.getAllPolled();
        int totalCount = c.getCount();
        Cursor c1 = db.getVotes(H);
        int Count = c1.getCount();
        int percentage = ( ( (int) Count* 100) / (int) totalCount);
        if (c1.moveToFirst()) {
            TextView text = new TextView(this);
            results.append("\n" + c1.getString(0) + " received "
                            + c1.getCount() + " vote(s), " + "and has " + percentage + "%" + " of the votes" + "\n"
            );

            container.addView(text);
        }
    }
}
