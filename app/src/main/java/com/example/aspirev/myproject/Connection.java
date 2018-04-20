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

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;


public class Connection extends AppCompatActivity  {

      EditText email , mdp ;
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

        String username = pref.getString("email","");
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
                    if (remember(v)){
                        editor.putString("email",email.getText().toString());
                        editor.putString("password",mdp.getText().toString());
                        editor.apply();
                    }
                    Toast.makeText(Connection.this, "Successfully login.", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Connection.this, MainActivity.class);
                    startActivity(in);
                }else
                {Toast.makeText(Connection.this, "Wrong password or email, try again.", Toast.LENGTH_SHORT).show();}
            }
        });

        task.execute("http://192.168.1.38/PFE/login1.php");
    }


    public void userReg(View v){
        Intent intent = new Intent(this,Inscription.class);
        startActivity(intent);
    }

   /* @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        checkFlag = b;
        Log.d(TAG, "checkFlag:  "+ checkFlag);
    }*/


    public boolean remember(View v) {
        checkFlag = cbRememeber.isChecked();
        Log.d(TAG, "checkFlag:  "+ checkFlag);
        return cbRememeber.isChecked();
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
