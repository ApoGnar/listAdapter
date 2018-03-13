package com.example.apo.listadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Apo on 3/12/2018.
 */

public class MyAdapterInbox extends RecyclerView.Adapter<ViewHolderInbox>{

    Context c;
    ArrayList<MyInbox> myInboxes;

    public MyAdapterInbox(Context c, ArrayList<MyInbox> myInboxes) {
        this.c = c;
        this.myInboxes = myInboxes;
    }

    @Override
    public ViewHolderInbox onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model_inbox,parent,false);
        return new ViewHolderInbox(v);
    }

    // bazei sto textView tou Holder to swsto stoixeio ths listas
    @Override
    public void onBindViewHolder(ViewHolderInbox holder, int position) {
        holder.firstname.setText(myInboxes.get(position).getFirstname());
        holder.lastmessage.setText(myInboxes.get(position).getLastMessage());

    }

    @Override
    public int getItemCount() {
        return myInboxes.size();
    }
}





