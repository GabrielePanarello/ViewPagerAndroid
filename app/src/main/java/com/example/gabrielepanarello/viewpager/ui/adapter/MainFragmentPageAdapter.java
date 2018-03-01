package com.example.gabrielepanarello.viewpager.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gabrielepanarello.viewpager.R;
import com.example.gabrielepanarello.viewpager.ui.fragment.SimpleFragment;

/**
 * Created by Gabriele Panarello on 01/03/2018.
 */

public class MainFragmentPageAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public MainFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        SimpleFragment simpleFragment = new SimpleFragment();

        Bundle args = new Bundle();

        switch (position) {
            case 0:
                args.putString("Fragment_Text", "Fragment 1");
                break;

            case 1:
                args.putString("Fragment_Text", "Fragment 2");
                break;

            case 2:
                args.putString("Fragment_Text", "Fragment 3");
                break;
        }

        simpleFragment.setArguments(args);
        return simpleFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return mContext.getString(R.string.tab_name_1);
            case 1:
                return mContext.getString(R.string.tab_name_2);
            case 2:
                return mContext.getString(R.string.tab_name_3);
            default:
                return null;
        }
    }
}
