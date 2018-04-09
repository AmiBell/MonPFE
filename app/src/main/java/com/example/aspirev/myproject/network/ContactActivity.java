package com.example.aspirev.myproject.network;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aspirev.myproject.R;

/**
 * Created by lenovo on 06/04/2018.
 */

public class ContactActivity extends AppCompatActivity{

    EditText et_sujet,et_message;
    Button btn_send;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacte);
        et_sujet=(EditText)findViewById(R.id.id_sujet);
        et_message=(EditText)findViewById(R.id.id_message);
        btn_send=(Button) findViewById(R.id.btnEnvoiMsg);
    }

    public void send(View v){
        String to = "soniahassouna1@gmail.com";
        String subject = et_sujet.getText().toString();
        String message = et_message.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[] {to});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Select Email app"));
    }
}
