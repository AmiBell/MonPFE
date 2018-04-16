package com.example.aspirev.myproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MyLocalisation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_localisation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.vehicule) {
            Intent intent = new Intent(this,Vehicule.class);
            startActivity(intent);

        } else if (id == R.id.modifierinfoperso) {
            Intent intent = new Intent(this,InfoPerso.class);
            startActivity(intent);


        } else if (id == R.id.cherchercovoiturage) {
            Intent intent = new Intent(this,ChercherCovoiturage.class);
            startActivity(intent);

        } else if (id == R.id.proposercovoiturage) {
            Intent intent = new Intent(this,ProposerCovoiturage.class);
            startActivity(intent);

        } else if (id == R.id.contactez) {
            Intent intent = new Intent(this,Contactez_nous.class);
            startActivity(intent);


        } else if (id == R.id.prefrences) {
            Intent intent = new Intent(this,Preference.class);
            startActivity(intent);


        }else if (id==R.id.avenir){
            Intent intent = new Intent(this,MesTrajetsAvenir.class);
            startActivity(intent);

        }else if (id==R.id.res){
            Intent intent = new Intent(this,MesReservations.class);
            startActivity(intent);

        }else if (id==R.id.map){
            Intent intent = new Intent(this,MyLocalisation.class);
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static final String TAG = "MainActivity";
    private boolean mLocationPermissiongranted = false ;
    private final static int location_permission_reqeust_code = 1234 ;
    private GoogleMap mMap ;


    private void InitMap(){
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                mMap = googleMap ;
            }
        });
    }

    private void getDeviceLocation(){
        Log.d(TAG,"getDeviceLocation:getting the devices current location ");

    }




    private void getLocationPermission(){
        String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION};
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION )==
                PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),Manifest.permission.ACCESS_COARSE_LOCATION)==
                    PackageManager.PERMISSION_GRANTED){
                mLocationPermissiongranted=true ;
                InitMap();
            }

        } else {
            ActivityCompat.requestPermissions(this , permissions,location_permission_reqeust_code);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissiongranted=false ;
        switch(requestCode){
            case location_permission_reqeust_code:{
                if(grantResults.length>0){
                    for(int i=0;i<grantResults.length;i++){
                        if(grantResults[i]!= PackageManager.PERMISSION_GRANTED){

                            mLocationPermissiongranted=false ;
                            break ;
                        }

                    } mLocationPermissiongranted=true ;
                    InitMap();

                }
            }

        }
    }

}
