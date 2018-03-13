package com.example.apo.listadapter;

import android.widget.ImageView;

/**
 * Created by Apo on 3/12/2018.
 */

public class MyInbox {

    String firstname = null;
    String lastname = null;
    String lastMessage = null;
    ImageView image = null;

    MyInbox(){

    }


    MyInbox (String firstname, String lastname, String lastMessage, ImageView image){
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.lastMessage = lastMessage;
    }


    public String getFirstname() {

        return firstname;
    }


    public String getLastname() {

        return lastname;
    }


    public String getLastMessage() {

        return lastMessage;
    }


    public ImageView getImage() {

        return image;
    }

}
