package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
/**
 * Created by amynashAmy on 08/03/16.
 */
public class QuestionPage1 extends AppCompatActivity {

    Button button1;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    RadioGroup group1;
    RadioGroup group2;
    RadioGroup group3;
    RadioGroup group4;
    RadioGroup group5;
    String radio_string1;
    String radio_string2;
    String radio_string3;
    String radio_string4;
    String radio_string5;
    String itemvalue;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions1);

        Bundle bundle = getIntent().getExtras();
        itemvalue = (bundle.getString("text0"));


        textView1 = (TextView)findViewById(R.id.textView1);
        group1 = (RadioGroup)findViewById(R.id.group1);
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                RadioButton checked = (RadioButton) findViewById(checkedId);
                radio_string1 = checked.getText().toString();

            }
        });

        textView2 = (TextView)findViewById(R.id.textView2);
        group2 = (RadioGroup)findViewById(R.id.group2);
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                RadioButton checked = (RadioButton)findViewById(checkedId);
                radio_string2 = checked.getText().toString();

            }
        });

        textView3 = (TextView)findViewById(R.id.textView3);
        group3 = (RadioGroup)findViewById(R.id.group3);
        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                RadioButton checked = (RadioButton)findViewById(checkedId);
                radio_string3 = checked.getText().toString();

            }
        });

        textView4 = (TextView)findViewById(R.id.textView4);
        group4 = (RadioGroup)findViewById(R.id.group4);
        group4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                RadioButton checked = (RadioButton)findViewById(checkedId);
                radio_string4 = checked.getText().toString();

            }
        });

        textView5 = (TextView)findViewById(R.id.textView5);
        group5 = (RadioGroup)findViewById(R.id.group5);
        group5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                RadioButton checked = (RadioButton)findViewById(checkedId);
                radio_string5 = checked.getText().toString();

            }
        });

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuestionPage1.this, QuestionPage2.class);
                intent.putExtra("text0", itemvalue);
                intent.putExtra("text1", radio_string1);
                intent.putExtra("text2", radio_string2);
                intent.putExtra("text3", radio_string3);
                intent.putExtra("text4", radio_string4);
                intent.putExtra("text5", radio_string5);


                startActivity(intent);

            }
        });

    }
}