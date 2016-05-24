package com.example.amynashamy.electionpoll;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{
    //this CustomList is a class which extends ArrayAdapter in order to customize the ListView

    private final Activity context;
    private final String[] Candidates;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] Candidates, Integer[] imageId) {
        super(context, R.layout.activity_candidate_row, Candidates);
        this.context = context;
        this.Candidates = Candidates;
        this.imageId = imageId;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_candidate_row, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(Candidates[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
