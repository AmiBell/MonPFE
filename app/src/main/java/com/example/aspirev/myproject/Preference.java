package com.example.aspirev.myproject;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Preference extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DataBaseHelper myDb ;

    RadioGroup music,cigarette,discussion;
    Button btnValiderPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      //  myDb = new DataBaseHelper(this);
        music = (RadioGroup)findViewById(R.id.id_radmusic);
        cigarette = (RadioGroup)findViewById(R.id.id_radcigarette);
        discussion = (RadioGroup)findViewById(R.id.id_raddisc);
        btnValiderPreference = (Button) findViewById(R.id.id_validpref);
       // addPreference();

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


  /*  public void addPreference() {
        //Button valide = (Button) findViewById(R.id.id_validpref);
        btnValiderPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m = music.getCheckedRadioButtonId();
                int c = cigarette.getCheckedRadioButtonId();
                int d = discussion.getCheckedRadioButtonId();
                RadioButton rd = (RadioButton) findViewById(m);
                RadioButton rd1 = (RadioButton) findViewById(c);
                RadioButton rd2 = (RadioButton) findViewById(d);
                String ms = rd.getText().toString();
                String mr = rd1.getText().toString();

                String mc = rd2.getText().toString();
                boolean isInserted = myDb.insertpreference( ms, mr, mc);
                if(isInserted == true)
                {Toast.makeText(Preference.this, "modifications validées.", Toast.LENGTH_LONG).show();}
                else Toast.makeText(Preference.this, "Veuillez réessayer.", Toast.LENGTH_LONG).show();


            }
        });

    }*/


}






