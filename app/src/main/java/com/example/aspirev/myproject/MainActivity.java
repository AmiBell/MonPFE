package com.example.aspirev.myproject;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private static  final int ERROR_DIALOG_REQUEST = 9001 ;


    DataBaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(isServiceOk()){
            init();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myDb = new DataBaseHelper(this);
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
            Intent intent = new Intent(this,Preference.class);
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

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private  void init(){


            }






    protected boolean isServiceOk(){
        Log.d(TAG,"isServiceOk:cheking google service version ");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available== ConnectionResult.SUCCESS)
        {
            Log.d(TAG,"isServiceOk: google service is working  ");
            return true ;
        }else
        if(GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {

            Log.d(TAG,"isServiceOk: gan error occured but we can fix it  ");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();

        } else {
            Toast.makeText(this,"you can't make map request",Toast.LENGTH_SHORT).show();

        }
        return false  ;
    }






}
