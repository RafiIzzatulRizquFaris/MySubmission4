package com.example.mysubmission4.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mysubmission4.FavoriteTabAdapter;
import com.example.mysubmission4.R;
import com.google.android.material.tabs.TabLayout;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        FragmentPagerAdapter sectionsPagerAdapter = new FavoriteTabAdapter(this, getSupportFragmentManager());
        ViewPager fViewPager = findViewById(R.id.fav_view_pager);
        fViewPager.setAdapter(sectionsPagerAdapter);
        TabLayout fTabLayout = findViewById(R.id.fav_tab_layout);
        fTabLayout.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark),getResources().getColor(android.R.color.white));
        fTabLayout.setupWithViewPager(fViewPager);
    }
}
