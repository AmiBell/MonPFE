package com.example.aspirev.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Detail_listCov_Activity extends AppCompatActivity {

    TextView txtDep,txtArv,txtDate,txtHeure,txtGenreComp,txtPrix,txtNbPlace;
    public  final String TAG= "Deatils";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_cov_);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Offres offre = (Offres) getIntent().getSerializableExtra("Offres");

        txtArv= (TextView) findViewById(R.id.txtArv);
        txtDate= (TextView) findViewById(R.id.txtDate);
        txtDep= (TextView) findViewById(R.id.txtDep);
        txtHeure= (TextView) findViewById(R.id.txtHeure);
        txtDate= (TextView) findViewById(R.id.txtDate);
        txtGenreComp= (TextView) findViewById(R.id.txtGenreComp);
        txtPrix= (TextView) findViewById(R.id.txtPrix);
        txtNbPlace= (TextView) findViewById(R.id.txtNbPlace);

        if (offre != null){
            Log.d(TAG, "onCreate:offre != null ");
            txtDate.setText(offre.dateDep);
            txtHeure.setText(offre.heureDep);
            txtGenreComp.setText(offre.genreCompagnie);
            txtNbPlace.setText(""+offre.nbPlaceTotal);
        }else {
            Log.d(TAG, "onCreate: offre == null");
        }

    }
}
