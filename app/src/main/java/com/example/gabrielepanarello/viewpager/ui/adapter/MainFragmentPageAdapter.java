package com.example.gabrielepanarello.viewpager.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gabrielepanarello.viewpager.R;
import com.example.gabrielepanarello.viewpager.ui.fragment.EmailFragment;
import com.example.gabrielepanarello.viewpager.ui.fragment.ContactListFragment;
import com.example.gabrielepanarello.viewpager.ui.fragment.StaticImageViewFragment;

/**
 * Created by Gabriele Panarello on 01/03/2018.
 */

public class MainFragmentPageAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int tabPosition;

    public MainFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        tabPosition = position;

        Fragment result = new StaticImageViewFragment();

        switch (position) {
            case 0:
                result = new StaticImageViewFragment();
                break;

            case 1:
                result = new ContactListFragment();
                break;

            case 2:
                result = new EmailFragment();
                break;
        }


        return result;
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

    public int getTabPosition(){
        return tabPosition;
    }
}
