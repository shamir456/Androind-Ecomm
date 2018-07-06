package com.example.shameer.mysqlw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Btn_signin,Btn_signup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_signin = (Button)findViewById(R.id.Btn_signin);
        Btn_signup = (Button)findViewById(R.id.Btn_signup);
        //  TextView textSlogan = (TextView).findViewById(R.id.txtSlogan);

        //Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Magnificent.TTF");




        Btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup= new Intent(MainActivity.this,Signup.class);
                startActivity(signup);
                //onBackPressed();




            }


        });

        Btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn= new Intent(MainActivity.this,SignIn.class);
                startActivity(signIn);
            }
        });


    }

}
