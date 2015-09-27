package com.nanodegree.mdaniel.popularmovies1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nanodegree.mdaniel.popularmovies1.R;
import com.nanodegree.mdaniel.popularmovies1.model.MovieModel;
import com.nanodegree.mdaniel.popularmovies1.ui.MovieActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdaniel on 28/07/2015.
 */
public  class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private List<MovieModel> mMovies;

    public MovieRecyclerViewAdapter() {
        mMovies = new ArrayList<MovieModel>();
    }

    public MovieModel getValueAt(int position) {
        return mMovies.get(position);
    }

    public void addMovies(List<MovieModel> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.grid_item, parent, false);
        //view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        final MovieModel movie = mMovies.get(position);
        Context context = holder.imgThumbnail.getContext();
        Picasso.with(context).load("http://image.tmdb.org/t/p/w342//"+ movie.getposter_path()).into(holder.imgThumbnail);
        //holder.mTextFirstName.setText(profile.get_first_name());
        //holder.mTextLasteName.setText(profile.get_last_name());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MovieActivity.class);
                intent.putExtra("movieId", movie.getid());
                intent.putExtra("movieTitle", movie.gettitle());
                intent.putExtra("movieBackDrop", "http://image.tmdb.org/t/p/w342//"+ movie.getbackdrop_path());
                intent.putExtra("moviePoster", "http://image.tmdb.org/t/p/w342//"+ movie.getposter_path());
                intent.putExtra("synopsis", movie.getoverview());
                intent.putExtra("user_rating", movie.getvote_average());
                intent.putExtra("release_date", movie.getrelease_date());
                context.startActivity(intent);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgThumbnail;
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            //mImageAvatar = (ImageView) view.findViewById(R.id.avatar);
            //mTextFirstName = (TextView) view.findViewById(android.R.id.text1);
            //mTextLasteName = (TextView) view.findViewById(android.R.id.text2);
        }
    }
}