package com.example.shameer.mysqlw;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

public class Signup extends AppCompatActivity {

    MaterialEditText edtphone,edtname,edtpassword;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtname = (MaterialEditText)findViewById(R.id.edtname);
        edtphone=(MaterialEditText)findViewById(R.id.edtphone);
        edtpassword=(MaterialEditText)findViewById(R.id.edtpassword);

        btnSignup=(Button) findViewById(R.id.Btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtname.getText().toString();
                String password= edtpassword.getText().toString();
                String phone=edtphone.getText().toString();
                String type=phone;
                BackgroundWorker backgroundWorker= new BackgroundWorker(Signup.this);
                backgroundWorker.execute(type,username,password);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        onBackPressed();
                        // Actions to do after 10 seconds
                    }
                }, 5000);




            }
        });
    }
    public void onBackPressed(){
        Intent mainActivity= new Intent(Signup.this,MainActivity.class);

        startActivity(mainActivity);
        finish();
    }
}
