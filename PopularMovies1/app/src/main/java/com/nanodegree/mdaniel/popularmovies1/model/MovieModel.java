package com.nanodegree.mdaniel.popularmovies1.model;


import java.util.ArrayList;

/**
 * Created by mDaniel on 26/06/2015.
 */
public class MovieModel {

    public boolean adult;
    public String backdrop_path;
    public ArrayList genre_ids;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public String release_date;
    public String poster_path;
    public float popularity;
    public String title;
    public boolean video;
    public float vote_average;
    public int vote_count;

    public boolean getadult() {
        return adult;
    }
    public String getbackdrop_path() {
        return backdrop_path;
    }
    public ArrayList getgenre_ids() {
        return genre_ids;
    }
    public int getid() {
        return id;
    }
    public String getoriginal_language() {
        return original_language;
    }
    public String getoriginal_title() {
        return original_title;
    }
    public String getoverview() {
        return overview;
    }
    public String getrelease_date() {
        return release_date;
    }
    public String getposter_path() {
        return poster_path;
    }
    public float getpopularity() {
        return popularity;
    }
    public String gettitle() {
        return title;
    }
    public boolean getvideo() {
        return video;
    }
    public float getvote_average() {
        return vote_average;
    }
    public int getvote_count() {
        return vote_count;
    }

    /*@Override
    public String toString() {
        return "AccountModel{" +
                "access_token=" + access_token +
                ", email_verified='" + email_verified + '\'' +
                ", facebook_id='" + facebook_id + '\'' +
                ", beta='" + beta + '\'' +
                ", owner_profile_id='" + owner_profile_id + '\'' +
                ", id='" + id + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", token_expires='" + token_expires + '\'' +
                '}';
    }*/
}

