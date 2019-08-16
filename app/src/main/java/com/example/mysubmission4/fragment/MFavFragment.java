package com.example.mysubmission4.fragment;


import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.mysubmission4.R;
import com.example.mysubmission4.adapter.FavoriteMovieAdapter;

import static com.example.mysubmission4.DatabaseContract.CONTENT_URI;

/**
 * A simple {@link Fragment} subclass.
 */
public class MFavFragment extends Fragment {


    private ProgressBar mfProgessBar;
    private FavoriteMovieAdapter favoriteMovieAdapter;
    private Cursor list;
    private RecyclerView mFRecylerView;

    public MFavFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        new loadData().execute();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mfav, container, false);

        favoriteMovieAdapter = new FavoriteMovieAdapter(this);

        mFRecylerView = v.findViewById(R.id.rv_favorite_movie);
        mFRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mFRecylerView.setHasFixedSize(true);
        mFRecylerView.setAdapter(favoriteMovieAdapter);

        new loadData().execute();

        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private class loadData extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return getContext().getContentResolver().query(
                    CONTENT_URI,
                    null,
                    null,
                    null,
                    null
            );
        }
        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            Log.d("CURSORS",cursor.toString());
            list = cursor;
            favoriteMovieAdapter.setCursor(list);
            favoriteMovieAdapter.notifyDataSetChanged();

        }
    }
}
