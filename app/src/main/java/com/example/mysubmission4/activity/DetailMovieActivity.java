package com.example.mysubmission4.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mysubmission4.ApiConfig;
import com.example.mysubmission4.R;
import com.example.mysubmission4.pojo.Movie;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    Movie movie;
    ImageView posterMovie;
    CollapsingToolbarLayout collapsingMovie;
    TextView movieOverview, movieVote, movieDate, moviePop;
    FloatingActionButton btnBackDrop;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie_acitivity);
        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        collapsingMovie = findViewById(R.id.collapsing_movie);
        collapsingMovie.setCollapsedTitleTextColor(getResources().getColor(R.color.colorWhite));
        collapsingMovie.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        collapsingMovie.setTitle(movie.getTitle());

        posterMovie = findViewById(R.id.movie_poster);
        String posterPath = movie.getPosterPath();
        String posterFix = ApiConfig.IMAGE_URL+posterPath;
        Glide.with(this).load(posterFix).into(posterMovie);

        movieVote = findViewById(R.id.movie_vote);
        movieVote.setText(String.valueOf(movie.getVoteAverage()));

        moviePop = findViewById(R.id.movie_pop);
        moviePop.setText(String.valueOf(movie.getPopularity()));

        movieDate = findViewById(R.id.movie_date);
        movieDate.setText(movie.getReleaseDate());

        movieOverview = findViewById(R.id.movie_overview);
        movieOverview.setText(movie.getOverview());

        String backDropPath = movie.getBackdropPath();
        String backDPFix = ApiConfig.IMAGE_URL+backDropPath;
        btnBackDrop = findViewById(R.id.btn_backDrop);
        btnBackDrop.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(backDPFix));
            startActivity(intent);
        });
    }
}
