package com.example.aspirev.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.aspirev.myproject.Inscription;

import Classes.BackgroundTask;
import Classes.Membre;
import Database.MembreRepository;
import Local.CovoiturageDatabase;
import Local.MembreDataSource;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by lenovo on 06/03/2018.
 */

public class Inscription extends AppCompatActivity {

    //Database
    private CompositeDisposable compositeDisposable;
    private MembreRepository membreRepository;
    private EditText editemail , editnom , editprenom , editmdp , editconfirmemdp , editAnneeNaiss;
    private RadioGroup sexe ;
    private RadioButton homme;
    private RadioButton femme;
    private CheckBox cgu ;
    private Button inscription ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        //Database
       CovoiturageDatabase userDatabase= CovoiturageDatabase.getmInstance(this); //create database
        membreRepository  = MembreRepository.getmInstance(MembreDataSource.getInstance(userDatabase.membreDAO()));

          editemail = (EditText)findViewById(R.id.id_email);
          editnom = (EditText)findViewById(R.id.id_nom);
          editprenom = (EditText)findViewById(R.id.id_prenom);
          editmdp = (EditText)findViewById(R.id.id_mdp);
          editAnneeNaiss = (EditText)findViewById(R.id.id_annnee);
          editconfirmemdp = (EditText)findViewById(R.id.id_mdpConf);
          sexe = (RadioGroup)findViewById(R.id.rgInscription);
          inscription = (Button) findViewById(R.id.btn_validerInscription);
          cgu  = (CheckBox)findViewById(R.id.checkBox_cgu);
          sexe=(RadioGroup)findViewById(R.id.rgInscription);


         // addMembre();

    }
    public String rbClick(View v){
        int radiobuttonid = sexe.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(radiobuttonid);
        return (String) rb.getText();
    }

    public boolean onCheck(View v){
        if(cgu.isChecked())return true;
        Toast.makeText(Inscription.this, "Il faut accepter les contraintes générales d'utilisation.", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void addMembre() {
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailTXT = editemail.getText().toString();
                final String passTxt = editmdp.getText().toString();
                final String anneeTxt = editAnneeNaiss.getText().toString();
                final String nomTxt = editnom.getText().toString();
                final String prenomTxt = editprenom.getText().toString();
                final String editconfirmemdpTXT = editconfirmemdp.getText().toString();
                //  final String check = String.valueOf(sexe.getCheckedRadioButtonId());
                final String radio = (String) rbClick(view);
                boolean ischecked = onCheck(view);
                if (ischecked) {

                    if (emailTXT.equals("") || passTxt.equals("") ||
                            nomTxt.equals("") || prenomTxt.equals("") ||
                            anneeTxt.equals("") || editconfirmemdpTXT.equals("") || radio.equals("")) {
                        Toast.makeText(Inscription.this, "Tous les champs sont obligatoires", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        if (!passTxt.equals(editconfirmemdpTXT)) {
                            Toast.makeText(Inscription.this, "Mot de passe incorrect", Toast.LENGTH_SHORT).show();

                        } else {

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
                            } else {
                                Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {

                                    @Override
                                    public void subscribe(ObservableEmitter<Object> e) throws Exception {
                                        Membre user = new Membre(emailTXT, nomTxt, prenomTxt, passTxt, (parseInt(anneeTxt)), radio);

                                        membreRepository.insertUser(user);
                                        e.onComplete();

                                    }
                                })
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribeOn(Schedulers.io())
                                        .subscribe(new Consumer() {
                                            @Override
                                            public void accept(Object o) throws Exception {
                                                Toast.makeText(Inscription.this, "User added", Toast.LENGTH_LONG).show();
                                            }
                                        }, new Consumer<Throwable>() {
                                            @Override
                                            public void accept(Throwable throwable) throws Exception {
                                                Toast.makeText(Inscription.this, "" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                                            }
                                        });


                            }
                        }
                    }
                }
            }
        });


    }

 public void userReg(View v){
         String emailTXT = editemail.getText().toString();
         String passTxt = editmdp.getText().toString();
         String anneeTxt = editAnneeNaiss.getText().toString();
         String nomTxt = editnom.getText().toString();
         String prenomTxt = editprenom.getText().toString();
         String radio = (String) rbClick(v);
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,emailTXT,nomTxt,prenomTxt,anneeTxt,passTxt,radio);
       finish();

    }


/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();

    }*/
}

