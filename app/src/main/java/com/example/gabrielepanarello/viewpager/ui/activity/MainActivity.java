package com.example.gabrielepanarello.viewpager.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.gabrielepanarello.viewpager.R;
import com.example.gabrielepanarello.viewpager.ui.adapter.MainFragmentPageAdapter;

public class MainActivity extends AppCompatActivity {

    private MainFragmentPageAdapter fragmentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentPageAdapter = new MainFragmentPageAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(fragmentPageAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
