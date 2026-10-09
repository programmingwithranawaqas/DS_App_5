package com.example.ds_app_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentA extends ListFragment {


    public interface SendPosition{
        public void onSetPosition(int position);
    }


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> names = new ArrayList<>();
        names.add("Waqas");
        names.add("Ali");
        names.add("Andaleeb");
        names.add("Aurangzaib");
        names.add("Maryam Nawaz");
        names.add("Waqas");
        names.add("Ali");
        names.add("Andaleeb");
        names.add("Aurangzaib");
        names.add("Maryam Nawaz");

        setListAdapter(new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, names));

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        SendPosition parent = (SendPosition) requireContext();
        parent.onSetPosition(position);

    }
}