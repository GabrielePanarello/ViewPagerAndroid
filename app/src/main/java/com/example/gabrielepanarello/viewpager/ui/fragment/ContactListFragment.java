package com.example.gabrielepanarello.viewpager.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gabrielepanarello.viewpager.R;
import com.example.gabrielepanarello.viewpager.data.Contact;
import com.example.gabrielepanarello.viewpager.logic.Utils;
import com.example.gabrielepanarello.viewpager.ui.activity.AddActivity;
import com.example.gabrielepanarello.viewpager.ui.activity.DetailActivity;
import com.example.gabrielepanarello.viewpager.ui.adapter.CustomArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriele Panarello on 14/03/2018.
 */

public class ContactListFragment extends Fragment {

    private CustomArrayAdapter adapter;

    @Override
    public void onResume() {
        super.onResume();
        adapter.clear();
        adapter.addAll(Utils.getContactsList());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
                return true;
            }

            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contact_list_layout,container,false);

        Utils.init();
        List<Contact> contactsList = new ArrayList<Contact>(Utils.getContactsList());

        adapter = new CustomArrayAdapter(getActivity(),contactsList);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = Utils.getContactsList().get(position).getName();
                String number = Utils.getContactsList().get(position).getNumber();
                int color = Utils.getColorForPosition(getActivity(),position);

                Intent intent = new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("number",number);
                intent.putExtra("color",color);
                startActivity(intent);

            }
        });

        return rootView;
    }
}
