package com.nanodegree.mdaniel.popularmovies1.services;

import com.nanodegree.mdaniel.popularmovies1.model.BoxOfficeModel;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by mdaniel on 27/07/2015.
 */
public class RestService {

    String absolute_url = "http://api.themoviedb.org";
    String key = "3addd8d64258066c7280afd821613b78";

    public void getBoxOfficeModel(String sort_by, Callback<BoxOfficeModel> callback) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(absolute_url)
                .build();

        MovieApi movieService = restAdapter.create(MovieApi.class);
        movieService.getBoxOfficeModel(sort_by,key,callback);
    }
}
