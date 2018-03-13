package com.example.apo.listadapter.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.apo.listadapter.FirebaseHelperContacts;
import com.example.apo.listadapter.FirebaseHelperInbox;
import com.example.apo.listadapter.MyAdapterInbox;
import com.example.apo.listadapter.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ThirdFragment extends Fragment {

    DatabaseReference db_contacts;
    FirebaseHelperContacts helper;
    RecyclerView rv;
    EditText nameEditTxt;
    MyAdapterInbox adapter_inbox;


    // newInstance constructor for creating fragment with arguments
    public static SecondFragment newInstance() {
        SecondFragment fragmentSecond = new SecondFragment();
//        Bundle args = new Bundle();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
//        fragmentFirst.setArguments(args);
        return fragmentSecond;
    }



    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        page = getArguments().getInt("someInt", 0);
//        title = getArguments().getString("someTitle");
    }



    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate
                (R.layout.fragment_second, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //SETUP RV
        rv= (RecyclerView) view.findViewById(R.id.rv);
        //wste na einai se linear morfh ta viewHolders, to ena katw apo to allo
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //SETUP FB
        db_inbox= FirebaseDatabase.getInstance().getReferenceFromUrl("https://listadapter-master.firebaseio.com/MyInbox");

        // ena database reefernece einai o helper
        helper=new FirebaseHelperInbox(db_inbox);

        //ADAPTER
        //stelnw ston adapter mia lista me ta onomata twn object tupou Spacecraft
        adapter_inbox=new MyAdapterInbox(getContext(),helper.retrieve());

        //bazw sto view , sthn sugkekrimenh periptwsh RecyclerView ton adapter
        rv.setAdapter(adapter_inbox);


        return view;

    }
}



