package com.example.apo.listadapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Apo on 3/12/2018.
 */

public class FirebaseHelperContacts {


    DatabaseReference db;
    Boolean saved=null;
    ArrayList<MyContact> myContacts=new ArrayList<>();

    public FirebaseHelperContacts(DatabaseReference db) {

        this.db = db;
    }


// tha doume an xreiazetai h save , giati kanoume retrieving mono pros stigmhn
    //SAVE
//    public Boolean save(MyInbox myInbox)
//    {
//        if(myInbox==null)
//        {
//            saved=false;
//        }else {
//
//            try
//            {
//                db.child("Spacecraft").push().setValue(myInbox);
//                saved=true;
//            }catch (DatabaseException e)
//            {
//                e.printStackTrace();
//                saved=false;
//            }
//
//        }
//
//        return saved;
//    }

    //READ
    public ArrayList<MyContact> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return myContacts;
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        myInboxes.clear();

        // update kanei thn lista, h fetchData()
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            MyInbox inbox=ds.getValue(MyInbox.class);
            myInboxes.add(inbox);
        }
    }

}



