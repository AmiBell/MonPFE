package com.example.aspirev.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.aspirev.myproject.Inscription;


/**
 * Created by lenovo on 06/03/2018.
 */

public class Inscription extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);


    }

  /*  public void addMembre() {
        btnValiderInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailTXT = editEmail.getText().toString();
                final String passTxt = editMdp.getText().toString();
                final String anneeTxt = editAnnee.getText().toString();
                final String nomTxt = editNom.getText().toString();
                final String prenomTxt = editPrenom.getText().toString();

                if (emailTXT.equals("") || passTxt.equals("") ||
                        nomTxt.equals("") || prenomTxt.equals("") ||
                        anneeTxt.equals("")) {
                    Toast.makeText(Inscription.this, "Tous les champs sont obligatoires", Toast.LENGTH_SHORT).show();
                    return;
                }

                // On déclare le pattern que l’on doit vérifier
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                // On déclare un matcher, qui comparera le pattern avec la
                // string passée en argument
                Matcher m = p.matcher(emailTXT);
                // Si l’adresse mail saisie ne correspond au format d’une
                // adresse mail on un affiche un message à l'utilisateur
                if (!m.matches()) {
                    // Toast est une classe fournie par le SDK Android
                    // pour afficher les messages (indications) à l'intention de
                    // l'utilisateur. Ces messages ne possédent pas d'interaction avec l'utilisateur
                    // Le premier argument représente le contexte, puis
                    // le message et à la fin la durée d'affichage du Toast (constante
                    // LENGTH_SHORT ou LENGTH_LONG). Sans oublier d'appeler la méthode
                    //show pour afficher le Toast
                    Toast.makeText(Inscription.this, "Adresse email invalide.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }else{

                boolean isInserted = myDb.insertMembre(editEmail.getText().toString(),
                        editNom.getText().toString(),
                        editPrenom.getText().toString(),
                        editMdp.getText().toString(),
                        Long.parseLong(editAnnee.getText().toString()));
                if (isInserted) {
                    Toast.makeText(Inscription.this, "Félicitation! vous etes inscrit.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Inscription.this, "L'inscription a échouée, veuillez rééssayer.", Toast.LENGTH_LONG).show();
                }}
                myDb.close();
            }
        });
    }

*/

    public void selectcgu(View view){

    }
    public void selecttype(View view){
        
    }
        }
