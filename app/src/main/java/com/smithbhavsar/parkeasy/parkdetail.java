package com.smithbhavsar.parkeasy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smithbhavsar.parkeasy.Adapters.Adapterarea;
import com.smithbhavsar.parkeasy.models.Areaname;

import java.util.ArrayList;
import java.util.List;

public class parkdetail extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Areaname> areanamese = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new Adapterarea(areanamese, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(parkdetail.this,Spot.class);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

                Toast.makeText(parkdetail.this, "Make a short Press", Toast.LENGTH_SHORT).show();
            }
        }));

        setData();
    }

    void setData() {
//        areanamese.add(new Areaname("nikoll", 3, 23.0446, 72.6683, "kaushik"));
//        areanamese.add(new Areaname("nikoll", 3, 23.0446, 72.6683, "kaushik"));
//        areanamese.add(new Areaname("nikoll", 3, 23.0446, 72.6683, "kaushik"));
//        areanamese.add(new Areaname("nikoll", 3, 23.0446, 72.6683, "kaushik"));

        FirebaseDatabase.getInstance().getReference().child("Location").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Areaname areaname = dataSnapshot.getValue(Areaname.class);
                areanamese.add(areaname);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adapter.notifyDataSetChanged();
    }


}
