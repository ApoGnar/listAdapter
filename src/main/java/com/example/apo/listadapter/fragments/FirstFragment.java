package com.example.apo.listadapter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apo.listadapter.R;


public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // methodo dhmiourgias constructor , borousame k me ton klasiko tropo
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        // to someInt einai key
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate
                (R.layout.fragment_first, container, false);

        TextView tvLabel = (TextView) view.findViewById(R.id.textView);
        tvLabel.setText(page + " -- " + title);
        return view;
    }
}
