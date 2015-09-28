package com.nanodegree.mdaniel.popularmovies1.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanodegree.mdaniel.popularmovies1.R;
import com.nanodegree.mdaniel.popularmovies1.model.ArrayMovies;
import com.nanodegree.mdaniel.popularmovies1.model.BoxOfficeModel;
import com.nanodegree.mdaniel.popularmovies1.services.RestService;
import com.nanodegree.mdaniel.popularmovies1.ui.adapter.MovieRecyclerViewAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by mdaniel on 28/09/2015.
 */
public class MovieFragment extends Fragment implements Callback<BoxOfficeModel> {

    private MovieRecyclerViewAdapter mGridAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    static ArrayMovies array_movies;


    public static MovieFragment newInstance(String sortBy) {
        MovieFragment myFragment = new MovieFragment();

        Bundle args = new Bundle();
        args.putString("sortBy", sortBy);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_popular, container, false);
        RestService rest = new RestService();
        rest.getBoxOfficeModel(getArguments().getString("sortBy", ""), this);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        mLayoutManager = new GridLayoutManager(recyclerView.getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        mGridAdapter = new MovieRecyclerViewAdapter();
        recyclerView.setAdapter(mGridAdapter);
    }

    @Override
    public void success(BoxOfficeModel boxOfficeModel, Response response) {
        array_movies=boxOfficeModel.getArrayMovies();
        mGridAdapter.addMovies(array_movies);
        for(int i=0;i<array_movies.size();i++){
        }
    }

    @Override
    public void failure(RetrofitError error) {
    }

}
