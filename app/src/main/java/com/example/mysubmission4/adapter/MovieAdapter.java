package com.example.mysubmission4.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysubmission4.ApiConfig;
import com.example.mysubmission4.R;
import com.example.mysubmission4.click.CustomOnClickListener;
import com.example.mysubmission4.pojo.Movie;

import java.util.List;

import static com.example.mysubmission4.DatabaseContract.CONTENT_URI;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.JUDUL;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.MOVIE_ID;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.OVERVIEW;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.POSTER;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.RELEASE;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.VOTE;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList1) {
        this.context = context;
        this.movieList = movieList1;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        final Movie movielist = movieList.get(position);
        String imgUrl = ApiConfig.IMAGE_URL + movieList.get(position).getPosterPath();
        Glide.with(context).load(imgUrl).override(150, 175).into(holder.imageViewPoster);
        holder.textViewTitle.setText(movieList.get(position).getTitle());
        holder.textViewDate.setText(movieList.get(position).getReleaseDate());
        holder.btnFavMovie.setOnClickListener(new CustomOnClickListener(position, (view, position1) -> {
            addFavourite(movielist);
            Toast.makeText(context, "Favorited "+movielist.getTitle(), Toast.LENGTH_SHORT).show();

        }));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewDate;
        ImageView imageViewPoster;
        Button btnFavMovie;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tv_item_name_movie);
            imageViewPoster = itemView.findViewById(R.id.img_item_photo_movie);
            textViewDate = itemView.findViewById(R.id.movie_final_date);
            btnFavMovie = itemView.findViewById(R.id.btn_fav_movie);
        }
    }

    private void addFavourite(Movie movielist) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(JUDUL, movielist.getTitle());
        contentValues.put(MOVIE_ID, movielist.getId());
        contentValues.put(OVERVIEW, movielist.getOverview());
        contentValues.put(POSTER, movielist.getPosterPath());
        contentValues.put(RELEASE, movielist.getReleaseDate());
        contentValues.put(VOTE, movielist.getVoteAverage());
        context.getContentResolver().insert(CONTENT_URI,contentValues);

        String TAG = "Details: ";
        Log.d(TAG, "Content Values: " + contentValues);

    }
}
