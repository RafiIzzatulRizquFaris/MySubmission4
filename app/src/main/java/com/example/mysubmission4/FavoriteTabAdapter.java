package com.example.mysubmission4;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mysubmission4.fragment.MFavFragment;
import com.example.mysubmission4.fragment.TFavFragment;

public class FavoriteTabAdapter extends FragmentPagerAdapter {

    private int[] title = new int[]{R.string.title_movies, R.string.title_tv_show};
    private Context fContext;

    public FavoriteTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        fContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                return new MFavFragment();
            case 1:
                return new TFavFragment();
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fContext.getResources().getString(title[position]);
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
