package com.example.shameer.mysqlw;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
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

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class BackgroundWorker extends AsyncTask<String,String,String> {
    Context context;
    AlertDialog alertDialog;
    public BackgroundWorker() {

    }
    String result="";
    public String chk="";
    int flag=2;
    BackgroundWorker(Context ctx)
    {
        context=  ctx;
    }

 //Toast.makeText(SignIn.this,"Sign In Success",Toast.LENGTH_SHORT).show();

    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        String login_url= "http://10.0.0.159/login.php";
        String signup_url="http://10.0.0.159/Signup.php";
        if(type.equals("login"))
        {
            try {
                String user_name=params[1];
                String password=params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String line="";
                while ((line= bufferedReader.readLine())!=null)
                {
                    result+=line;
                }

                JSONObject json = new JSONObject(result);


                if (json.getString("success").toString().equalsIgnoreCase("welcome"))
                {
                     flag=1;

                    Intent logged = new Intent(context, Product_list.class);
                    context.startActivity(logged);


                } else if (json.getString("fail").toString().equalsIgnoreCase("failed")) {
                    // android.support.v7.app.AlertDialog alertDialog;
                    flag=0;




                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
//                JSONObject json = new JSONObject(result);



                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                String user_name=params[1];
                String password=params[2];
                String phone=params[0];
                URL url = new URL(signup_url);
               ;
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));


                String line="";
                while ((line= bufferedReader.readLine())!=null)
                {
                    result+=line;

                }




                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();

       // alertDialog=new AlertDialog.Builder(context).create();

        //alertDialog.setTitle("Login status");
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login status");



    }

    @Override
    protected void onPostExecute(String result) {
        //super.onPostExecute(aVoid);


        if(flag==1)
        {
            alertDialog.setMessage("Login successful");
            alertDialog.show();
        }
        else if(flag==0)
        {
            alertDialog.setMessage("Login FAILED");
            alertDialog.show();
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();


        }






//        alertDialog.dismiss();


       // result.toString();
















    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

}
