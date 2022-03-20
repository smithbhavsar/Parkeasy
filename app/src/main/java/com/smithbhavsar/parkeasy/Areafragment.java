package com.smithbhavsar.parkeasy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smithbhavsar.parkeasy.models.Areaname;


/**
 * A simple {@link Fragment} subclass.
 */
public class Areafragment extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    public Areafragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        recyclerView.findViewById(R.id.recyclerview);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Areaname");
        return inflater.inflate(R.layout.fragment_areaname, container, false);
    }

}
