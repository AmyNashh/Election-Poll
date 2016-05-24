package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;;


/**
 * Created by amynashAmy on 08/03/16.
 */
public class QuestionPage2 extends AppCompatActivity {


    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private String spinner_string1;
    private String spinner_string2;
    private String spinner_string3;
    private String spinner_string4;
    private String spinner_string5;
    Button button1;

    ///////////////////all radio buttons and checkboxes from question page 1////////

    String radio_string1;
    String radio_string2;
    String radio_string3;
    String radio_string4;
    String radio_string5;
    String itemvalue;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);

        Bundle bundle = getIntent().getExtras();
        itemvalue = (bundle.getString("text0"));
        radio_string1 = (bundle.getString("text1"));
        radio_string2 = (bundle.getString("text2"));
        radio_string3 = (bundle.getString("text3"));
        radio_string4 = (bundle.getString("text4"));
        radio_string5 = (bundle.getString("text5"));


        spinner1 = (Spinner) findViewById(R.id.agespinner);
        spinner2 = (Spinner) findViewById(R.id.empspinner);
        spinner3 = (Spinner) findViewById(R.id.incspinner);
        spinner4 = (Spinner) findViewById(R.id.perfspinner);
        spinner5 = (Spinner) findViewById(R.id.locspinner);


        ////////Spinenr1/////////

        List<String> list1 = new ArrayList<String>();

        list1.add("18-25");
        list1.add("26-35");
        list1.add("36-45");
        list1.add("46-55");
        list1.add("56-65");
        list1.add("66+");

        ArrayAdapter<String> agespinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);
        agespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(agespinner);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_string1 = spinner1.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ///////spinner2///////
        List<String> list2 = new ArrayList<String>();

        list2.add("Employed");
        list2.add("Unemployed");
        list2.add("Student");

        ArrayAdapter<String> empspinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        empspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(empspinner);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_string2 = spinner2.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /////spinner3////

        List<String> list3 = new ArrayList<String>();

        list3.add("less than 10,000");
        list3.add("10,000 - 30,000");
        list3.add("30,000 - 50,000");
        list3.add("50,000 - 70,000");
        list3.add("70,000 - 90,000");
        list3.add("+90,000");

        ArrayAdapter<String> incspinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);
        incspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3.setAdapter(incspinner);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_string3 = spinner3.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /////spinner4////

        List<String> list4 = new ArrayList<String>();

        list4.add("Water charges");
        list4.add("Road Conditions");
        list4.add("Health");
        list4.add("Housing");
        list4.add("Other");

        ArrayAdapter<String> perfspinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list4);
        perfspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner4.setAdapter(perfspinner);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_string4 = spinner4.getSelectedItem().toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ////spinner5////

        List<String> list5 = new ArrayList<String>();

        list5.add("West Galway");
        list5.add("East Galway");
        list5.add("South Galway");
        list5.add("North Galway");

        ArrayAdapter<String> locspinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list5);
        locspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner5.setAdapter(locspinner);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_string5 = spinner5.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuestionPage2.this, EndQuestionActivity.class);

                intent.putExtra("text0", itemvalue);
                intent.putExtra("text1", radio_string1);
                intent.putExtra("text2", radio_string2);
                intent.putExtra("text3", radio_string3);
                intent.putExtra("text4", radio_string4);
                intent.putExtra("text5", radio_string5);
                intent.putExtra("text6", spinner_string1);
                intent.putExtra("text7", spinner_string2);
                intent.putExtra("text8", spinner_string3);
                intent.putExtra("text9", spinner_string4);
                intent.putExtra("text10", spinner_string5);


                startActivity(intent);

            }
        });


        ////end/////

        }


    }