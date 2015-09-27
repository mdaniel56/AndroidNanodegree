package com.nanodegree.mdaniel.popularmovies1.ui;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.nanodegree.mdaniel.popularmovies1.R;
import com.nanodegree.mdaniel.popularmovies1.adapter.MovieRecyclerViewAdapter;
import com.nanodegree.mdaniel.popularmovies1.model.ArrayMovies;
import com.nanodegree.mdaniel.popularmovies1.model.BoxOfficeModel;
import com.nanodegree.mdaniel.popularmovies1.services.QueryEvent;
import com.nanodegree.mdaniel.popularmovies1.services.RestService;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<BoxOfficeModel> {

    private MovieRecyclerViewAdapter mGridAdapter;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    static ArrayMovies array_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestService rest = new RestService();
        rest.getBoxOfficeModel("popularity.desc", "3addd8d64258066c7280afd821613b78", this);

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mGridAdapter = new MovieRecyclerViewAdapter();
        mRecyclerView.setAdapter(mGridAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                EventBus.getDefault().post(new QueryEvent(query));
                //if you want to collapse the searchview
                invalidateOptionsMenu();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
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

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(QueryEvent event){
        ArrayMovies search_array_movies = null;
        for(int i=0;i<array_movies.size();i++){
            if(array_movies.get(i).getoriginal_title().equals(event.getQuery())){
                search_array_movies.add(array_movies.get(i));
                mGridAdapter.addMovies(search_array_movies);
            }
        }
    }
}
