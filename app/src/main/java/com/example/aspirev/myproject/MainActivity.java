package com.example.aspirev.myproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.io.Serializable;
import java.util.ArrayList;




public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AsyncResponse, AdapterView.OnItemClickListener{
    private static final String TAG1 = "MainActivity";
    private static  final int ERROR_DIALOG_REQUEST = 9001 ;


    SharedPreferences pref;
    final String TAG = this.getClass().getName();
    SharedPreferences.Editor editor;

    private ArrayList<Offres> offreList;
    private ListView lvOffre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnConnection = (Button)findViewById(R.id.id_chercher) ;
        Button btnInscription= (Button)findViewById(R.id.id_proposer);
        btnConnection.setOnClickListener(this);
        btnInscription.setOnClickListener(this);
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


        pref = getSharedPreferences("login.conf", Context.MODE_PRIVATE);
        Log.d(TAG1, pref.getString("email",""));
        Log.d(TAG1, pref.getString("password",""));


        PostResponseAsyncTask taskRead = new PostResponseAsyncTask(MainActivity.this, this);
        taskRead.execute("http://192.168.1.38/PFE/showCov.php");

    }


    private void goToNextActivity(){
        Intent intent = new Intent(this,ChercherCovoiturage.class);
        startActivity(intent);
    }

    private void goToNextActivity2(){
        Intent intent = new Intent(this,ProposerCovoiturage.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_chercher:
                goToNextActivity();
                break;
            case R.id.id_proposer:
                goToNextActivity2();
                break;
            default:
                break;

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

        }else if(id == R.id.deconnexion){
            editor=pref.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(MainActivity.this,Connection.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private  void init(){}

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
            Log.d(TAG,"isServiceOk: an error occured but we can fix it  ");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else
        {
            Toast.makeText(this,"you can't make map request",Toast.LENGTH_SHORT).show();
        }
        return false  ;
    }


    @Override
    public void processFinish(String s) {

        offreList = new JsonConverter<Offres>().toArrayList(s, Offres.class);

        //insert the data that I get from JSON
        BindDictionary<Offres> dict = new BindDictionary<Offres>();

        dict.addStringField(R.id.date, new StringExtractor<Offres>() {
            @Override
            public String getStringValue(Offres offres, int position) {
                return ""+offres.dateDep;
            }
        });

        dict.addStringField(R.id.heure, new StringExtractor<Offres>() {
            @Override
            public String getStringValue(Offres offres, int position) {
                return ""+offres.heureDep;
            }
        });

        FunDapter<Offres> adapter = new FunDapter<Offres>(MainActivity.this,offreList, R.layout.layout_list_cov, dict);
        lvOffre = (ListView)findViewById(R.id.listCov);
        lvOffre.setAdapter(adapter);
        Log.d(TAG, "processFinish: finishe successfuly");
        lvOffre.setOnItemClickListener(this);
        Log.d(TAG, "processFinish: item clicked");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d(TAG, "onItemClick: clicked");

        Offres selectedOffre = offreList.get(position);

        Intent in = new Intent(MainActivity.this, Detail_listCov_Activity.class);

        try {
            in.putExtra("Offres", (Serializable) selectedOffre);
        }catch (ClassCastException e){
            //
        }
        startActivity(in);
    }
}
