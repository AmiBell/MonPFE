package com.example.aspirev.myproject;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.EditText;


import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import java.util.HashMap;

import Database.MembreRepository;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lenovo on 06/03/2018.
 */

public class Connection extends AppCompatActivity {
    private CompositeDisposable compositeDisposable;
    private MembreRepository membreRepository;
      EditText email , mdp ;
      String login_email,login_pass;
      Button btn ;
      CheckBox cbRememeber;
      SharedPreferences pref;
      SharedPreferences.Editor editor;

      boolean checkFlag;

      final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
        email=(EditText)findViewById(R.id.ETemail);
        mdp=(EditText)findViewById(R.id.ETpassword);
        btn =(Button)findViewById(R.id.email_sign_in_button);
        cbRememeber=(CheckBox)findViewById(R.id.cbRemember);

        Log.d(TAG,"checkFlag: " + checkFlag);

        pref = getSharedPreferences("login.conf", Context.MODE_PRIVATE);
        editor=pref.edit();

        String username = pref.getString("username","");
        String password = pref.getString("password","");

        HashMap data = new HashMap();
        data.put("email",username);
        data.put("password",password);

        if (!(username.equals("") && password.equals(""))){

           PostResponseAsyncTask task = new PostResponseAsyncTask(Connection.this,data, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    Log.d(TAG, s);
                    if (s.contains("success")){
                        Intent in = new Intent(Connection.this, MainActivity.class);
                        startActivity(in);
                    }
                }
            });

            task.execute("http://192.168.1.38/PFE/login1.php");

        }
    }

    public void userLogin(final View v){
        HashMap data = new HashMap();
        data.put("email",email.getText().toString());
        data.put("password",mdp.getText().toString());

        final PostResponseAsyncTask task = new PostResponseAsyncTask(Connection.this,data, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                Log.d(TAG, s);
                if (s.contains("success")){
                    if (checkFlag = remember(v)){
                        editor.putString("email",email.getText().toString());
                        editor.putString("password",mdp.getText().toString());
                        editor.apply();
                    }
                    Intent in = new Intent(Connection.this, MainActivity.class);
                    startActivity(in);
                }
            }
        });

        task.execute("http://192.168.1.38/PFE/login1.php");
    }


    public void userReg(View v){
        Intent intent = new Intent(this,Inscription.class);
        startActivity(intent);
    }

    public boolean remember(View v) {
        if (cbRememeber.isChecked()== true) return true;
        return false;
    }
    /*
    public void userLogin(View v){
        login_email=email.getText().toString();
        login_pass=mdp.getText().toString();
        String method="login";
        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute(method,login_email,login_pass);
    }*/
}
