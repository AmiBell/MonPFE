package com.example.aspirev.myproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by AspireV on 2018-03-05.
 */

public class MapLocalisation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        getLocationPermission();
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



