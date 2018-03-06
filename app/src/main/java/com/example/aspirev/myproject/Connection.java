package com.example.aspirev.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lenovo on 06/03/2018.
 */

public class Connection extends AppCompatActivity {

    Button btnConnection = (Button)findViewById(R.id.email_sign_in_button) ;
    Button btnInscription= (Button)findViewById(R.id.email_subscribe_button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity();
            }
        });
        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity2();
            }
        });
    }

    private void goToNextActivity(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void goToNextActivity2(){
        Intent intent= new Intent(this,Inscription.class);
        startActivity(intent);
    }
}
