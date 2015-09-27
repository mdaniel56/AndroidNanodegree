package com.nanodegree.mdaniel.popularmovies1.model;


/**
 * Created by mDaniel on 26/06/2015.
 */
public class BoxOfficeModel {

    public int page;
    public ArrayMovies results;
    public int total_pages;
    public int total_results;

    public int getPage() {
        return page;
    }
    public ArrayMovies getArrayMovies() {
        return results;
    }
    public int getTotal_pages() {
        return total_pages;
    }
    public int getTotal_results() {
        return total_results;
    }

}

