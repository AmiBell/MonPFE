package com.example.aspirev.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by lenovo on 06/03/2018.
 */

public class Connection extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
        Button btnConnection = (Button)findViewById(R.id.email_sign_in_button) ;
        Button btnInscription= (Button)findViewById(R.id.email_subscribe_button);
        btnConnection.setOnClickListener(this);
        btnInscription.setOnClickListener(this);
    }
    public void Select(View view){
        boolean checked = ((CheckBox)view).isChecked();

    }

    private void goToNextActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void goToNextActivity2(){
        Intent intent = new Intent(this,Inscription.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                goToNextActivity();
                break;
            case R.id.email_subscribe_button:
                goToNextActivity2();
                break;
            default:
                break;

        }
    }
}
