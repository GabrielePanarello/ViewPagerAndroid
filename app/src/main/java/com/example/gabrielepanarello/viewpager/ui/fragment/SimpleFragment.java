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
 * Created by Gabriele Panarello on 01/03/2018.
 */

public class SimpleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tw = (TextView) view.findViewById(R.id.mainTextView);
        tw.setText(getArguments().getString("Fragment_Text"));
    }
}
