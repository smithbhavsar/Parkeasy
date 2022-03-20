package com.smithbhavsar.parkeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;
import com.smithbhavsar.parkeasy.models.Areaname;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void test(View view) {
        EditText t, la, lo, a, sub;
        t = findViewById(R.id.editText2);
        sub = findViewById(R.id.editText6);
        a = findViewById(R.id.editText3);
        la = findViewById(R.id.editText4);
        lo = findViewById(R.id.editText5);

        String title = t.getText().toString();
        int av = Integer.valueOf(a.getText().toString());
        double latitude = Double.valueOf(la.getText().toString());
        double longitude = Double.valueOf(lo.getText().toString());

        Areaname areaname = new Areaname(title, av, latitude, longitude,sub.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Areafragment").push().setValue(areaname);
        FirebaseDatabase.getInstance().getReference().child("Area").child(areaname.getTitle()).push().setValue(areaname);
    }
}
