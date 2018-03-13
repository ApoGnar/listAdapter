package com.example.apo.listadapter;

import android.widget.ImageView;

/**
 * Created by Apo on 3/13/2018.
 */

public class MyContact {

    String firstname = null;
    String lastname = null;
    String about_me = null;
    ImageView image = null;

    MyContact(){

    }


    MyContact(String firstname, String lastname, String about_me, ImageView image){
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.about_me = about_me;
    }


    public String getFirstname() {

        return firstname;
    }


    public String getLastname() {

        return lastname;
    }


    public String getAboutMe() {

        return about_me;
    }


    public ImageView getImage() {


        return image;
    }

}

