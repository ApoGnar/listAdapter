package com.example.apo.listadapter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.apo.listadapter.FirebaseHelperInbox;
import com.example.apo.listadapter.MyAdapterInbox;
import com.example.apo.listadapter.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SecondFragment extends Fragment {


    DatabaseReference db_inbox;
    FirebaseHelperInbox helper;
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
        db_inbox= FirebaseDatabase.getInstance().getReferenceFromUrl("https://listadapter-master.firebaseio.com/MyInbox/J6RLtFePHiWcjW5JikxGOiIzIaf1");

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




        //
//        final ListView listview = (ListView) view.findViewById(R.id.listview);
//
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
//                "Android", "iPhone", "WindowsMobile" };
//
//
//        list = new ArrayList<String>();
//
//        for (int i = 0; i < values.length; ++i) {
//            list.add(values[i]);
//        }
//
//        //proigoumeno example exei this (giati einai se Activity kai to Context pou einai mesa sto View , kaleite me 'this' h'
//        // getContext()  )
//
//        //View getContext what is context ??
//        final StableArrayAdapter adapter = new StableArrayAdapter(view.getContext(),
//                android.R.layout.simple_list_item_1, list);
//
//
//        listview.setAdapter(adapter);
//
//
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            //OnItemClick
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, final View view,
//                                    int position, long id) {
//
//                //get Item from whole List
//                final String item = (String) parent.getItemAtPosition(position);
//
//                //Result is an Item , to that item we do :
////                view.animate().setDuration(2000).alpha(0)
////                        .withEndAction(new Runnable() {
////                            @Override
////                            public void run() {
////                                // what we want to do.
//                               list.remove(item);
//                               adapter.notifyDataSetChanged();
////                                view.setAlpha(1);
////
////                            }
////                        });
//            }
//
//        });
//
//        return view;
//    }
//
//    //Unique Object extention of ArrayAdapter
//    private class StableArrayAdapter extends ArrayAdapter<String> {
//
//        //HashMap = Key value pair , with String : 'android' , Interger : index=1
//        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();
//
//        //Constructor of ArrayAdapter<String>, edw einai kai ta orismata pou exw steilei , opote object=list
//        public StableArrayAdapter(Context context, int textViewResourceId,
//                                  List<String> objects) {
//            super(context, textViewResourceId, objects);
//
//            //get List objects , and insert it inside HashMap
//            for (int i = 0; i < objects.size(); ++i) {
//                mIdMap.put(objects.get(i), i);
//            }
//
//        }
//
//        //find item based on Position and the return it from HashMap .
//        @Override
//        public long getItemId(int position) {
//            String item = getItem(position);
//
//            return mIdMap.get(item);
//        }
//
//        @Override
//        public boolean hasStableIds() {
//            return true;
//        }
//
//    }
//
//        return view;
//
//    }
//}
