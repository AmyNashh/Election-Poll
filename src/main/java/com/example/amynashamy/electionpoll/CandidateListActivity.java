package com.example.amynashamy.electionpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by amynashAmy on 03/03/16.
 */
public class CandidateListActivity extends AppCompatActivity {

    ListView mylist;
    String itemvalue;

    String[] Candidates = {"Fidelma Healy Eames", "Noel Grealish", "Mary Hoade",
            "John Connolly", "Derek Nolan", "Niall O'Thuathail", "Hildegarde Naughton", "Sean Kyne"
    };//declare array of names


    Integer[] imageId = {//declare array of images
            R.drawable.healyeames,
            R.drawable.grealish,
            R.drawable.hoade,
            R.drawable.connolly,
            R.drawable.nolan,
            R.drawable.thuathail,
            R.drawable.naughton,
            R.drawable.kyne

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidatelist);

        CustomList adapter = new CustomList(CandidateListActivity.this, Candidates, imageId);
        //defines how the list items appears in listview.
        mylist = (ListView) findViewById(R.id.mylist);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemvalue = (String) mylist.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), itemvalue, Toast.LENGTH_SHORT).show();
                //When a list item is clicked it shows a toast that it is clicked.
               Intent intent = new Intent(CandidateListActivity.this, QuestionPage1.class);
                intent.putExtra("text0", itemvalue );

                startActivity(intent);


            }
        });
    }
}
