package com.example.gabrielepanarello.viewpager.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gabrielepanarello.viewpager.R;

/**
 * Created by Gabriele Panarello on 14/03/2018.
 */

public class StaticImageViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.static_imageview_layout,container,false);

        return rootView;
    }

}
