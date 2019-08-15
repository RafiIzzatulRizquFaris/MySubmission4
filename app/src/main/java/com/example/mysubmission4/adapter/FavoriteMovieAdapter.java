package com.example.mysubmission4.adapter;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysubmission4.ApiConfig;
import com.example.mysubmission4.MovieItem;
import com.example.mysubmission4.R;
import com.example.mysubmission4.fragment.MFavFragment;

public class FavoriteMovieAdapter extends RecyclerView.Adapter<FavoriteMovieAdapter.ViewHolder> {

    private Cursor cursor;
    private MFavFragment mFavFragment;

    public FavoriteMovieAdapter(MFavFragment mFavFragment, Cursor list) {
        this.mFavFragment = mFavFragment;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MovieItem movielist = getItem(position);
        String imgUrl = ApiConfig.IMAGE_URL + movielist.getPosterPath();
        Glide.with(mFavFragment).load(imgUrl).override(150, 175).into(holder.imageViewPoster);
        holder.textViewTitle.setText(movielist.getTitle());
        holder.textViewDate.setText(movielist.getReleaseDate());
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;
        return cursor.getCount();
    }

    private MovieItem getItem(int position) {
        if (!cursor.moveToPosition(position)) {
            throw new IllegalStateException("Position invalid");
        }
        return new MovieItem(cursor);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewPoster;
        TextView textViewTitle, textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tv_item_name_movie);
            imageViewPoster = itemView.findViewById(R.id.img_item_photo_movie);
            textViewDate = itemView.findViewById(R.id.movie_final_date);
        }
    }
}
