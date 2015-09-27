package com.nanodegree.mdaniel.popularmovies1.services;

import com.nanodegree.mdaniel.popularmovies1.model.BoxOfficeModel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Spit on 06/06/2015.
 */
public interface MovieApi {

    @GET("/3/discover/movie")
    void getBoxOfficeModel( @Query("sort_by") String email,
                            @Query("api_key") String key,
                            Callback<BoxOfficeModel> callback);
}
