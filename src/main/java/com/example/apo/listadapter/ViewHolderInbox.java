package com.example.apo.listadapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Apo on 3/12/2018.
 */

public class ViewHolderInbox extends RecyclerView.ViewHolder {

    Image img;
    TextView firstname;
    TextView lastmessage;

    public ViewHolderInbox (View itemView) {
        super(itemView);

        firstname=(TextView) itemView.findViewById(R.id.firstname);
        lastmessage=(TextView) itemView.findViewById(R.id.lastmessage);



    }
}





