package com.smithbhavsar.parkeasy;

import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smithbhavsar.parkeasy.models.Spotdetails;

public class Spot extends AppCompatActivity {
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);
        setData();
        countDownTimer = new CountDownTimer(1000*60,(1000*1)) {
            @Override
            public void onTick(long millisUntilFinished) {
                setData();
            }

            @Override
            public void onFinish() {
                onBackPressed();
            }
        }.start();
    }

    void setData() {
        DatabaseReference ans = FirebaseDatabase.getInstance().getReference().child("aventador").child("in_range");
        ans.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ansVale  = dataSnapshot.getValue().toString();
                if (Boolean.valueOf(ansVale)) {
                    TextView textView = findViewById(R.id.Center);
                    textView.setText("R");
                } else {
                    TextView textView = findViewById(R.id.Center);
                    textView.setText("E");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }
}
