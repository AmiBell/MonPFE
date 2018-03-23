package com.example.aspirev.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import Classes.BackgroundTask;
import Classes.Membre;
import Database.MembreRepository;
import Local.CovoiturageDatabase;
import Local.MembreDataSource;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lenovo on 06/03/2018.
 */

public class Connection extends AppCompatActivity {
    private CompositeDisposable compositeDisposable;
    private MembreRepository membreRepository;
      EditText email , mdp ;
      String login_email,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
       // Button btnConnection = (Button)findViewById(R.id.email_sign_in_button) ;
       // Button btnInscription= (Button)findViewById(R.id.email_subscribe_button);
       // btnConnection.setOnClickListener(this);
        //btnInscription.setOnClickListener(this);
        email=(EditText)findViewById(R.id.email);
        mdp=(EditText)findViewById(R.id.password);
        //Database
       // CovoiturageDatabase userDatabase= CovoiturageDatabase.getmInstance(this); //create database
      //  membreRepository  = MembreRepository.getmInstance(MembreDataSource.getInstance(userDatabase.membreDAO()));


    }

  /*  public void Select(View view){
        boolean checked = ((CheckBox)view).isChecked();

    }
    private boolean existe(){
   Flowable<Membre> membre = membreRepository.getUserById(email.getText().toString());
   if(membre==null){
       Toast.makeText(this,"Email introuvable",Toast.LENGTH_LONG).show();
       return false;
   }
   return true;
    }*/

 /*   private void goToNextActivity(){
        boolean exist = existe();
        if(exist)
        {Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);}
        else
            Toast.makeText(this,"Email introuvable",Toast.LENGTH_LONG).show();

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
    }*/

    public void userReg(View v){
        Intent intent = new Intent(this,Inscription.class);
        startActivity(intent);
    }

    public void userLogin(View v){
        login_email=email.getText().toString();
        login_pass=mdp.getText().toString();
        String method="login";
        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute(method,login_email,login_pass);
    }
}
