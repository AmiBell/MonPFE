package Classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.UriMatcher;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by lenovo on 20/03/2018.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context context;

    AlertDialog alertDialog;


    public BackgroundTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        alertDialog= new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Login information...");

    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://192.168.1.39/PFE/register1.php";
        String log_url = "http://192.168.1.39/PFE/login1.php";
        String method = params[0];
        if(method.equals("register")){

            String nom=params[2];
            String prenom=params[3];
            String email=params[1];
            String anneeNaiss=params[4];
            String password=params[5];
            String sexe=params[6];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true); //pass information
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("nom","UTF-8")+"="+URLEncoder.encode(nom,"UTF-8")+"&"+
                        URLEncoder.encode("prenom","UTF-8")+"="+URLEncoder.encode(prenom,"UTF-8")+"&"+
                        URLEncoder.encode("anneeNaiss","UTF-8")+"="+URLEncoder.encode(anneeNaiss,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("sexe","UTF-8")+"="+URLEncoder.encode(sexe,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {

            }
        }else if (method.equals("login")){
            String login_email=params[1];
            String login_pass=params[2];
            try {
                URL url=new URL(log_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(login_email,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line = bufferedReader.readLine())!= null){
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Registration success...")) Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}
