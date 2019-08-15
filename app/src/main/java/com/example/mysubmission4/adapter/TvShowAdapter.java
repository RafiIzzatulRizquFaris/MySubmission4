package com.example.mysubmission4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysubmission4.ApiConfig;
import com.example.mysubmission4.R;
import com.example.mysubmission4.pojo.TvShow;

import java.util.List;


public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private List<TvShow> tvShows1;
    private Context context;

    public TvShowAdapter(Context context, List<TvShow> tvShowList) {
        this.context = context;
        this.tvShows1 = tvShowList;
    }

    @NonNull
    @Override
    public TvShowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_tvshow, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.TvShowViewHolder holder, int position) {
        String urlImage = ApiConfig.IMAGE_URL + tvShows1.get(position).getPosterPath();
        Glide.with(context).load(urlImage).override(150, 175).into(holder.imageView);
        holder.textView.setText(tvShows1.get(position).getName());
        holder.textViewDate.setText(tvShows1.get(position).getFirstAirDate());
    }

    @Override
    public int getItemCount() {
        return tvShows1.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textViewDate;
        ImageView imageView;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_name_show);
            imageView = itemView.findViewById(R.id.img_item_photo_show);
            textViewDate = itemView.findViewById(R.id.show_final_date);
        }
    }
}
