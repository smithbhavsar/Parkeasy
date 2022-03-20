package com.smithbhavsar.parkeasy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.smithbhavsar.parkeasy.R.drawable.ic_menu_black_24dp;

public class ParkEasy extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FirebaseAuth mAuth;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.logo);
        mAuth = FirebaseAuth.getInstance();

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_main);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                if (ActivityCompat.checkSelfPermission(ParkEasy.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ParkEasy.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    ActivityCompat.requestPermissions(ParkEasy.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.ACCESS_COARSE_LOCATION},
                            101);
                    return;
                }

                mMap.setMyLocationEnabled(true);
                mMap = googleMap;
                LatLng sydney = new LatLng(23.0906, 72.5343);
                googleMap.addMarker(new MarkerOptions().position(sydney)
                        .title("Silveroak Parking"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        startActivity(new Intent(ParkEasy.this, Spot.class));
//                        Toast.makeText(ParkEasy.this, "kaushik tejani", Toast.LENGTH_SHORT).show();


                    }
                });
                mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                    @Override
                    public void onMyLocationChange(Location location) {

                    }
                });
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeaderView = navigationView.getHeaderView(0);

        ImageView imageView = navHeaderView.findViewById(R.id.user_image);
        TextView username = navHeaderView.findViewById(R.id.user_name);
        TextView email = navHeaderView.findViewById(R.id.user_email);

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            Glide.with(this).load(user.getPhotoUrl().toString()).into(imageView);
            username.setText(user.getDisplayName());
            email.setText(user.getEmail());
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            Intent i = new Intent(ParkEasy.this, parkdetail.class);

            startActivity(i);


        } else if (id == R.id.nav_search) {

            Search search = new Search();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.map_main, search).commit();


        } else if (id == R.id.nav_about_us) {

            Aboutus aboutus = new Aboutus();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.map_main, aboutus).commit();

        } else if (id == R.id.nav_signin_out) {

            mAuth.signOut();
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() == null) {
            finish();
            System.exit(0);
        }
    }

    public void onClick1(View v) {
        startActivity(new Intent(this, Admin.class));
    }

}
