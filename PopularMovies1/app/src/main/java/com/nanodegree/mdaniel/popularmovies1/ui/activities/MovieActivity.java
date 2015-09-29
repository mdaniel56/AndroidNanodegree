package com.nanodegree.mdaniel.popularmovies1.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanodegree.mdaniel.popularmovies1.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MovieActivity extends AppCompatActivity
{
    @Bind(R.id.releaseDate) TextView release_date;
    @Bind(R.id.userRating) TextView user_rating;
    @Bind(R.id.movieSynopsis) TextView synopsis;
    @Bind(R.id.moviePoster) ImageView cover;
    @Bind(R.id.backdrop) ImageView backdrop;
    @Bind(R.id.fab) FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        int movieId = getIntent().getIntExtra("movieId",0);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getIntent().getStringExtra("movieTitle"));
        collapsingToolbar.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);

        Picasso.with(this).load(getIntent().getStringExtra("movieBackDrop")).into(backdrop);

        release_date.setText(getIntent().getStringExtra("release_date"));
        user_rating.setText(getIntent().getStringExtra("user_rating")+ "/10");
        synopsis.setText(getIntent().getStringExtra("synopsis"));
        Picasso.with(this).load(getIntent().getStringExtra("moviePoster")).resize(320,500).into(cover);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Reviews enables in Stage 2", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}