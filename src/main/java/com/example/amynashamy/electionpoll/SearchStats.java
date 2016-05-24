package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amynashAmy on 21/03/16.
 */
public class SearchStats extends AppCompatActivity {

        private Spinner spinner1;
        private Spinner spinner2;
        private Spinner spinner3;
        private String spinner_string1;
        private String spinner_string2;
        private String spinner_string3;

        Button button1;
        MyDBManager db;


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_searchstats);

            db = new MyDBManager(this);
            spinner1 = (Spinner) findViewById(R.id.genderspinner);
            spinner2 = (Spinner) findViewById(R.id.agespinner);
            spinner3 = (Spinner) findViewById(R.id.locspinner);

            ////////
            List<String> list1 = new ArrayList<String>();
            list1.add("All");
            list1.add("Female");
            list1.add("Male");
            ArrayAdapter<String> genderspinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);
            genderspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(genderspinner);
            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   spinner_string1 = spinner1.getSelectedItem().toString();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            ///////
            List<String> list2 = new ArrayList<String>();

            list2.add("All");
            list2.add("18-25");
            list2.add("26-35");
            list2.add("36-45");
            list2.add("46-55");
            list2.add("56-65");
            list2.add("66+");

            ArrayAdapter<String> agespinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
            agespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner2.setAdapter(agespinner);
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 spinner_string2 = spinner2.getSelectedItem().toString();


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //////

            List<String> list3 = new ArrayList<String>();

            list3.add("All");
            list3.add("West Galway");
            list3.add("East Galway");
            list3.add("South Galway");
            list3.add("North Galway");

            ArrayAdapter<String> locspinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);
            locspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner3.setAdapter(locspinner);
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  spinner_string3 = spinner3.getSelectedItem().toString();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            //////

            button1 = (Button) findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(SearchStats.this, StatCalculations.class);
                    intent.putExtra("gender", spinner_string1);
                    intent.putExtra("age", spinner_string2);
                    intent.putExtra("locality", spinner_string3);
                    startActivity(intent);

                }
            });

        }

    }